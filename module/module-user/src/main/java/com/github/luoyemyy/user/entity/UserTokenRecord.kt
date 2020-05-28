package com.github.luoyemyy.user.entity

import java.util.Date

data class UserTokenRecord(
    var id: Long? = null,
    var userId: Long? = null,
    var token: String? = null,
    var tokenExpire: Date? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null
)