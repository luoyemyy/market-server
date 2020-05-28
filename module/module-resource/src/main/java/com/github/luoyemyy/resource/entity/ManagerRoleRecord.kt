package com.github.luoyemyy.resource.entity

import java.util.Date

data class ManagerRoleRecord(
    var id: Long? = null,
    var roleId: Long? = null,
    var managerId: Long? = null,
    var status: Int? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null
)