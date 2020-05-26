package com.github.luoyemyy.user.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("user") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val nickname = column<String>("nickname", JDBCType.VARCHAR)

        val headImg = column<String>("head_img", JDBCType.VARCHAR)

        val username = column<String>("username", JDBCType.VARCHAR)

        val phone = column<String>("phone", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val status = column<Int>("status", JDBCType.INTEGER)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)

        val updateTime = column<Date>("update_time", JDBCType.TIMESTAMP)
    }
}