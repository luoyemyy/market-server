package com.github.luoyemyy.user.service

import com.github.luoyemyy.common.advice.AppCode
import com.github.luoyemyy.user.bean.request.RequestLoginPhone
import com.github.luoyemyy.user.bean.request.RequestLoginUsername
import com.github.luoyemyy.user.bean.response.ResponseManagerLogin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService {

    @Autowired
    private lateinit var userService: UserService

    fun loginByUsername(param: RequestLoginUsername): ResponseManagerLogin {
        return userService.getByUsername(param.username)?.let {
            if (param.password.equals(it.password, true)) {
                return ResponseManagerLogin()
            } else {
                null
            }
        } ?: throw AppCode.ERROR_USERNAME_PASSWORD.throws()
    }

//    private fun login(userRecord: UserRecord): ResponseManagerLogin {
//
//    }

    fun loginByPhone(param: RequestLoginPhone): ResponseManagerLogin {
        return userService.getByPhone(param.phone)?.let {
            if (param.code.equals(it.password, true)) {
                return ResponseManagerLogin()
            } else {
                null
            }
        } ?: throw AppCode.ERROR_USERNAME_PASSWORD.throws()
    }
}