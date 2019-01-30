package mysql.config.read

interface ReadOption {
    fun getConfig(): Map<GroupName, Operater>
}
