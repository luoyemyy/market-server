package com.github.luoyemyy.resource.entity

import java.util.Date

data class RoleRecord(
    var id: Long? = null,
    var name: String? = null,
    var isAdmin: Int? = null,
    var status: Int? = null,
    var updateTime: Date? = null,
    var createTime: Date? = null
)