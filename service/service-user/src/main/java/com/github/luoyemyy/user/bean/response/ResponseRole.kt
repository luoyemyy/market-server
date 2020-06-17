package com.github.luoyemyy.user.bean.response

import io.swagger.annotations.ApiModel

@ApiModel
class ResponseRole {
    var roleId: Long = 0
    var name: String? = null
    var isAdmin: Int = 0
    var resources: List<ResponseResource>? = null

    companion object {
    }
}