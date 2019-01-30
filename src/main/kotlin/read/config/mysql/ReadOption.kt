package read.config.mysql

interface ReadOption {
    fun getConfig(): List<Option>
}
