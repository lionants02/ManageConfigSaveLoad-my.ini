package mysql.config.read

import mysql.config.GroupName
import mysql.config.Operater

interface ReadOption {
    fun getConfig(): Map<GroupName, Operater>
}
