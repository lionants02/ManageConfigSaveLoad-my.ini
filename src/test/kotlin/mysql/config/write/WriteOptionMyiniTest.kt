package mysql.config.write

import myIni
import mysql.config.copyFileUsingStream
import org.amshove.kluent.`should be equal to`
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import java.nio.file.Files
import kotlin.streams.toList

class WriteOptionMyiniTest {

    private val fileTest = File("mmyy.ini")

    @Before
    fun setUp() {
        copyFileUsingStream(myIni, fileTest)
    }

    @After
    fun tearDown() {
        fileTest.deleteOnExit()
    }

    @Test
    fun writeMysqld() {

        val writeOption: WriteOption = WriteOptionMyini(fileTest)
        writeOption.writeMysqld("ggg" to "aaa")

        Files.lines(fileTest.toPath()).filter {
            it == "ggg = aaa"
        }.toList().size `should be equal to` 1
    }
}
