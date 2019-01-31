package mysql.config.read

import myIni
import org.amshove.kluent.`should be`
import org.junit.Ignore
import org.junit.Test
import java.nio.file.Files

class ConfigMachineTest {

    private val configMachine = ReadStateMachine()

    @Test
    fun processComment() {
        configMachine.process("# xxddv") `should be` ReadStateMachine.Stage.NextLine
        configMachine.process("; xxddv") `should be` ReadStateMachine.Stage.NextLine
    }

    @Test
    fun processgetGroup() {
        configMachine.process("[mysqld]") `should be` ReadStateMachine.Stage.GetGroup
    }

    @Test
    fun processgetGetOpt() {
        configMachine.process("default-character-set=utf8") `should be` ReadStateMachine.Stage.GetOpt
        configMachine.process("""datadir="C:/Program Files/MySQL/Data/"""") `should be` ReadStateMachine.Stage.GetOpt
    }

    @Ignore("Print my ini")
    fun process() {

        Files.lines(myIni.toPath()).forEach {
            val start = try {
                it.substring(0, 5)
            } catch (ex: java.lang.StringIndexOutOfBoundsException) {
                it
            }

            val state = configMachine.process(it)

            println("$start\t$state")
        }
    }
}
