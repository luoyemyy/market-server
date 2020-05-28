package com.github.luoyemyy.resource.entity

import java.util.Date

data class ResourceRecord(
    var id: Long? = null,
    var parentId: Long? = null,
    var name: String? = null,
    var type: Int? = null,
    var pathId: Int? = null,
    var path: String? = null,
    var level: Int? = null,
    var status: Int? = null,
    var createTime: Date? = null,
    var updateTime: Date? = null
)