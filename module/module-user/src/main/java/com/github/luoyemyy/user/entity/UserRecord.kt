package com.github.luoyemyy.user.entity

import java.util.Date

data class UserRecord(
    var id: Long? = null,
    var nickname: String? = null,
    var headImg: String? = null,
    var username: String? = null,
    var phone: String? = null,
    var password: String? = null,
    var status: Int? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null
)