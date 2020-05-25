package com.github.luoyemyy.resource.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object RoleDynamicSqlSupport {
    object Role : SqlTable("role") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)

        val type = column<Int>("type", JDBCType.INTEGER)

        val status = column<Int>("status", JDBCType.INTEGER)

        val updateTime = column<Date>("update_time", JDBCType.TIMESTAMP)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)
    }
}