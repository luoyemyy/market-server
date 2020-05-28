package com.github.luoyemyy.resource.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object ResourceDynamicSqlSupport {
    object Resource : SqlTable("resource") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val parentId = column<Long>("parent_id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)

        val type = column<Int>("type", JDBCType.INTEGER)

        val pathId = column<Int>("path_id", JDBCType.INTEGER)

        val path = column<String>("path", JDBCType.VARCHAR)

        val level = column<Int>("level", JDBCType.INTEGER)

        val status = column<Int>("status", JDBCType.INTEGER)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)

        val updateTime = column<Date>("update_time", JDBCType.TIMESTAMP)
    }
}