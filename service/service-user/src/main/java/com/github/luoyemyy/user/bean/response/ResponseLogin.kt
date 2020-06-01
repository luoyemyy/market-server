package com.github.luoyemyy.user.bean.response

import com.github.luoyemyy.user.entity.UserRecord
import com.github.luoyemyy.user.entity.UserTokenRecord
import io.swagger.annotations.ApiModel

@ApiModel
open class ResponseLogin {

    var userId: Long = 0
    var nickname: String? = null
    var headImg: String? = null
    var username: String? = null
    var phone: String? = null
    var token: String? = null
    var tokenExpire: Long = 0

    companion object {
        fun mapTo(response: ResponseLogin, user: UserRecord, userToken: UserTokenRecord) {
            response.userId = user.id ?: 0
            response.nickname = user.nickname
            response.headImg = user.headImg
            response.username = user.username
            response.phone = user.phone
            response.token = userToken.token
            response.tokenExpire = userToken.tokenExpire ?: 0
        }
    }
}