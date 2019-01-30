package mysql.config.read

import myIni
import org.amshove.kluent.`should be equal to`
import org.junit.Test

class ReadOptionMyiniTest {

    val readOption = ReadOptionMyini(myIni)

    @Test
    fun `getGroup$MySqlReadConfig`() {

        readOption.getGroup("[mysqldump]") `should be equal to` "mysqldump"
    }

    @Test
    fun `getOpt$MySqlReadConfig`() {
        val opt = readOption.getOpt("max_allowed_packet = 16M")

        opt.first `should be equal to` "max_allowed_packet"
        opt.second `should be equal to` "16M"
    }

    @Test
    fun getConfig() {
        val config = readOption.getConfig()

        config["mysqld"]!!["log"]!! `should be equal to` "jlog.log"
        config["myisamchk"]!!["sort_buffer_size"]!! `should be equal to` "8M"
    }
}
