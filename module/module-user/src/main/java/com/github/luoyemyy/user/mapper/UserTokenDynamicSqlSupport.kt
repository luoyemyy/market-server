package com.github.luoyemyy.user.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UserTokenDynamicSqlSupport {
    object UserToken : SqlTable("user_token") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val userId = column<Long>("user_id", JDBCType.BIGINT)

        val token = column<String>("token", JDBCType.VARCHAR)

        val tokenExpire = column<Long>("token_expire", JDBCType.BIGINT)

        val createTime = column<Date>("create_time", JDBCType.TIMESTAMP)

        val updateTime = column<Date>("update_time", JDBCType.TIMESTAMP)
    }
}