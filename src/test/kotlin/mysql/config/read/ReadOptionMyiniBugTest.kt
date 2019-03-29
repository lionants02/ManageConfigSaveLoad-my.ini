package mysql.config.read

import myBugIni
import mysql.config.getGroup
import mysql.config.getOpt
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class ReadOptionMyiniBugTest {

    val readOption = ReadOptionMyini(myBugIni)

    @Test
    fun `getGroup$MySqlReadConfig`() {

        getGroup("[mysqldump]") `should be equal to` "mysqldump"
    }

    @Test
    fun `getOpt$MySqlReadConfig`() {
        val opt = getOpt("max_allowed_packet = 16M")

        opt.first `should be equal to` "max_allowed_packet"
        opt.second `should be equal to` "16M"
    }

    @Test
    fun getConfig() {
        val config = readOption.read()

        config.getValue("mysqld").getValue("character-set-server") `should be equal to` "utf8"
    }
}
