package mysql.config.read

import mysql.config.GroupName
import mysql.config.Operater
import mysql.config.getGroup
import mysql.config.getOpt
import mysql.config.read.ReadStateMachine.Stage.GetGroup
import mysql.config.read.ReadStateMachine.Stage.GetOpt
import mysql.config.read.ReadStateMachine.Stage.NextLine
import java.io.File
import java.nio.file.Files

class ReadOptionMyini(private val file: File) : ReadOption {

    private val configMachine = ReadStateMachine()

    override fun read(): Map<GroupName, Operater> {
        val output = hashMapOf<GroupName, Operater>()
        val reader = Files.lines(file.toPath())
        var group = ""

        var tempOperater = TempOperater()

        reader.forEach {
            when (configMachine.process(it)) {
                GetGroup -> {
                    if (group.isNotBlank()) {
                        output[group] = tempOperater.toMap()

                        tempOperater = TempOperater()
                    }
                    group = getGroup(it)
                }
                GetOpt -> {
                    val opt = getOpt(it)
                    tempOperater[opt.first] = opt.second
                }
                NextLine -> {
                }
            }
        }
        output[group] = tempOperater.toMap()
        reader.close()
        return output.toMap()
    }
}

internal typealias TempOperater = HashMap<String, String>
