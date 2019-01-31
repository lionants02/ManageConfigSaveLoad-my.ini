package mysql.config

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

typealias GroupName = String
typealias Operater = Map<String, String>

internal fun getGroup(str: String): String {
    return Regex("""^\[(.*)\]$""").matchEntire(str)!!.groupValues.last()
}

internal fun getOpt(str: String): Pair<String, String> {
    return try {
        val mapOpt = Regex("""^(.*)=(.*)$""").matchEntire(str)!!.groupValues
        mapOpt[mapOpt.size - 2].trim() to mapOpt.last().trim()
    } catch (ex: kotlin.KotlinNullPointerException) {
        str to ""
    }
}

fun copyFileUsingStream(source: File, dest: File) {
    var `is`: InputStream? = null
    var os: OutputStream? = null
    try {
        `is` = FileInputStream(source)
        os = FileOutputStream(dest)
        val buffer = ByteArray(1024)
        var length: Int
        length = `is`.read(buffer)

        while (length > 0) {
            os.write(buffer, 0, length)
            length = `is`.read(buffer)
        }
    } finally {
        `is`!!.close()
        os!!.close()
    }
}
