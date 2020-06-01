package com.github.luoyemyy.user.bean.response

import com.github.luoyemyy.resource.entity.ResourceRecord
import com.github.luoyemyy.resource.entity.RoleRecord
import io.swagger.annotations.ApiModel

@ApiModel
class ResponseRole {
    var roleId: Long = 0
    var name: String? = null
    var isAdmin: Int = 0
    var resources: List<ResponseResource>? = null

    companion object {
        fun map(role: RoleRecord, resources: List<ResourceRecord>): ResponseRole {
            return ResponseRole().apply {
                roleId = role.id ?: 0
                name = role.name
                isAdmin = role.isAdmin ?: 0
                this.resources = ResponseResource.map(resources)
            }
        }
    }
}