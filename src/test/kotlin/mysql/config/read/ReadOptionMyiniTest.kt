package mysql.config.read

import myIni
import mysql.config.getGroup
import mysql.config.getOpt
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class ReadOptionMyiniTest {

    val readOption = ReadOptionMyini(myIni)

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

        config["mysqld"]!!["log"]!! `should be equal to` "jlog.log"
        config["myisamchk"]!!["sort_buffer_size"]!! `should be equal to` "8M"
    }
}
