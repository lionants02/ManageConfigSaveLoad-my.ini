package read.config.mysql

interface ReadOption {
    fun getConfig(): Map<GroupName, Operater>
}
