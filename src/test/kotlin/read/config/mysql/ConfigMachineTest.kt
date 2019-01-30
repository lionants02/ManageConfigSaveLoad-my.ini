package read.config.mysql

import myIni
import org.amshove.kluent.`should be`
import org.junit.Ignore
import org.junit.Test

internal class ConfigMachineTest {

    val configMachine = ConfigMachine()

    @Test
    fun processComment() {
        configMachine.process("# xxddv") `should be` ConfigMachine.Stage.NextLine
        configMachine.process("; xxddv") `should be` ConfigMachine.Stage.NextLine
    }

    @Test
    fun processgetGroup() {
        configMachine.process("[mysqld]") `should be` ConfigMachine.Stage.GetGroup
    }

    @Test
    fun processgetGetOpt() {
        configMachine.process("default-character-set=utf8") `should be` ConfigMachine.Stage.GetOpt
        configMachine.process("""datadir="C:/Program Files/MySQL/Data/"""") `should be` ConfigMachine.Stage.GetOpt
    }

    @Ignore("Print my ini")
    fun process() {

        myIni.forEach {
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
