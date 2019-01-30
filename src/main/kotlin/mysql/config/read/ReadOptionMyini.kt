package mysql.config.read

import java.io.File
import java.nio.file.Files

class ReadOptionMyini(val file: File) : ReadOption {

    private val configMachine = ConfigMachine()

    override fun getConfig(): Map<GroupName, Operater> {
        val output = hashMapOf<GroupName, Operater>()
        val reader = Files.lines(file.toPath())
        var group = ""

        var tempOperater = TempOperater()

        reader.forEach {
            when (configMachine.process(it)) {
                ConfigMachine.Stage.GetGroup -> {
                    if (group.isNotBlank()) {
                        output[group] = tempOperater.toMap()

                        tempOperater = TempOperater()
                    }
                    group = getGroup(it)
                }
                ConfigMachine.Stage.GetOpt -> {
                    val opt = getOpt(it)
                    tempOperater[opt.first] = opt.second
                }
            }
        }
        return output.toMap()
    }

    internal fun getGroup(str: String): String {
        return Regex("""^\[(.*)\]$""").matchEntire(str)!!.groupValues.last()
    }

    internal fun getOpt(str: String): Pair<String, String> {
        return try {
            val mapOpt = Regex("""^(.*)=(.*)$""").matchEntire(str)!!.groupValues
            mapOpt[mapOpt.size - 2].trim() to mapOpt.last().trim()
        } catch (ex: kotlin.KotlinNullPointerException) {
            println("first parameter $str")
            str to ""
        }
    }
}
