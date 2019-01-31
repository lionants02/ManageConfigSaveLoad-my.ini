package mysql.config.read

import mysql.config.GroupName
import mysql.config.Operater
import mysql.config.getOpt
import java.io.File
import java.nio.file.Files

class ReadOptionMyini(val file: File) : ReadOption {

    private val configMachine = ReadStateMachine()

    override fun read(): Map<GroupName, Operater> {
        val output = hashMapOf<GroupName, Operater>()
        val reader = Files.lines(file.toPath())
        var group = ""

        var tempOperater = TempOperater()

        reader.forEach {
            when (configMachine.process(it)) {
                ReadStateMachine.Stage.GetGroup -> {
                    if (group.isNotBlank()) {
                        output[group] = tempOperater.toMap()

                        tempOperater = TempOperater()
                    }
                    group = mysql.config.getGroup(it)
                }
                ReadStateMachine.Stage.GetOpt -> {
                    val opt = getOpt(it)
                    tempOperater[opt.first] = opt.second
                }
            }
        }
        reader.close()
        return output.toMap()
    }
}

internal typealias TempOperater = HashMap<String, String>
