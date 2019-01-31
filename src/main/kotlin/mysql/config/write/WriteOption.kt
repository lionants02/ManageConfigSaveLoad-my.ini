package mysql.config.write

interface WriteOption {
    fun writeMysqld(wr: Pair<String, String>)
}
