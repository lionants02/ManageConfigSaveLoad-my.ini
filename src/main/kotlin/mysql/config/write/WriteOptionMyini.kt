package mysql.config.write

import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.util.LinkedList

class WriteOptionMyini(val file: File) : WriteOption {

    override fun writeMysqld(wr: Pair<String, String>) {
        val write = LinkedList<String>()
        val reader = Files.lines(file.toPath())

        reader.forEach {
            write.add(it)
            if (it.startsWith("[mysqld]")) {
                write.add(wr.first + "=" + wr.second)
            }
        }
        reader.close()

        val fileWriter = FileWriter(file, false)

        write.forEach {
            fileWriter.write(it)
            fileWriter.write(System.getProperty("line.separator"))
        }
        fileWriter.flush()
        fileWriter.close()
    }
}
