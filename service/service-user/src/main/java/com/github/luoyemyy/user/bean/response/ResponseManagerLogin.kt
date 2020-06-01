package com.github.luoyemyy.user.bean.response

import com.github.luoyemyy.user.entity.ManagerRecord
import com.github.luoyemyy.user.entity.UserRecord
import com.github.luoyemyy.user.entity.UserTokenRecord
import io.swagger.annotations.ApiModel

@ApiModel
class ResponseManagerLogin : ResponseLogin() {
    var manager: ResponseManager? = null

    companion object {
        fun map(user: UserRecord, userToken: UserTokenRecord, manager: ManagerRecord, roles: List<ResponseRole>): ResponseManagerLogin {
            return ResponseManagerLogin().also {
                mapTo(it, user, userToken)
                it.manager = ResponseManager.map(manager, roles)
            }
        }
    }
}