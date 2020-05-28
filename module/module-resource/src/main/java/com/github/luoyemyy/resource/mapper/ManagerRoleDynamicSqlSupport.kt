package com.github.luoyemyy.resource.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object ManagerRoleDynamicSqlSupport {
    object ManagerRole : SqlTable("manager_role") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val roleId = column<Long>("role_id", JDBCType.BIGINT)

        val managerId = column<Long>("manager_id", JDBCType.BIGINT)

        val status = column<Int>("status", JDBCType.INTEGER)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)

        val updateTime = column<Date>("update_time", JDBCType.TIMESTAMP)
    }
}