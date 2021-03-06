package com.github.luoyemyy.user.service

import com.github.luoyemyy.common.advice.AppCode
import com.github.luoyemyy.redis.service.RedisUserService
import com.github.luoyemyy.user.bean.request.RequestLoginPhone
import com.github.luoyemyy.user.bean.request.RequestLoginUsername
import com.github.luoyemyy.user.bean.response.ResponseLogin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService {

    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var redisUserService: RedisUserService

    fun loginByUsername(param: RequestLoginUsername): ResponseLogin {
        return userService.getByUsername(param.username)?.let {
            val userId = it.id
//            if (userId != null && param.password.equals(it.password, true)) {
//                redisUserService.getUserInfo(userId)
//                return ResponseManagerLogin()
//            } else {
                null
//            }
        } ?: throw AppCode.ERROR_USERNAME_PASSWORD.throws()
    }

//    private fun login(userRecord: UserRecord): ResponseManagerLogin {
//
//    }

    fun loginByPhone(param: RequestLoginPhone): ResponseLogin {
        return userService.getByPhone(param.phone)?.let {
            if (param.code.equals(it.password, true)) {
                return ResponseLogin()
            } else {
                null
            }
        } ?: throw AppCode.ERROR_USERNAME_PASSWORD.throws()
    }
}