package com.github.luoyemyy.user.entity

import java.util.Date

data class ManagerRecord(
    var id: Long? = null,
    var userId: Long? = null,
    var status: Int? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null
)