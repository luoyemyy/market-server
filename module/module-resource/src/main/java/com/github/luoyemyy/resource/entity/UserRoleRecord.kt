package com.github.luoyemyy.resource.entity

import java.util.Date

data class UserRoleRecord(
    var id: Long? = null,
    var userId: Long? = null,
    var roleId: Long? = null,
    var status: Int? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null
)