package com.github.luoyemyy.resource.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UserRoleDynamicSqlSupport {
    object UserRole : SqlTable("user_role") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val userId = column<Long>("user_id", JDBCType.BIGINT)

        val roleId = column<Long>("role_id", JDBCType.BIGINT)

        val status = column<Int>("status", JDBCType.INTEGER)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)

        val updateTime = column<Date>("update_time", JDBCType.TIMESTAMP)
    }
}