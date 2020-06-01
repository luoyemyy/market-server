package com.github.luoyemyy.user.bean.response

import com.github.luoyemyy.user.entity.ManagerRecord
import io.swagger.annotations.ApiModel

@ApiModel
class ResponseManager {
    var managerId: Long = 0
    var status: Int = 0
    var roles: List<ResponseRole>? = null

    companion object {
        fun map(manager: ManagerRecord, roles: List<ResponseRole>): ResponseManager {
            return ResponseManager().also {
                it.managerId = manager.id ?: 0
                it.status = manager.status ?: 0
                it.roles = roles
            }
        }
    }
}