package com.github.luoyemyy.user.controller

import com.github.luoyemyy.user.service.LoginService
import com.github.luoyemyy.common.aspect.AppApi
import com.github.luoyemyy.common.swagger.DataResponse
import com.github.luoyemyy.common.swagger.dateResponse
import com.github.luoyemyy.user.bean.request.RequestLoginPhone
import com.github.luoyemyy.user.bean.request.RequestLoginUsername
import com.github.luoyemyy.user.bean.request.RequestLoginWechat
import com.github.luoyemyy.user.bean.response.ResponseLogin
import com.github.luoyemyy.user.bean.response.ResponseManagerLogin
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["管理后台-登录"])
@RestController
@RequestMapping("api/user/login/manager")
class ManagerLoginController {

    @Autowired
    private lateinit var loginService: LoginService

    @AppApi(auth = false)
    @ApiOperation("用户名密码登录")
    @PostMapping("byUsername")
    fun byUsername(@RequestBody @Validated param: RequestLoginUsername): DataResponse<ResponseManagerLogin> {
        return dateResponse(loginService.loginByUsername(param))
    }

    @AppApi(auth = false)
    @ApiOperation("手机号验证码登录")
    @PostMapping("byPhone")
    fun byPhone(@RequestBody @Validated param: RequestLoginPhone): DataResponse<ResponseManagerLogin> {
        return dateResponse(loginService.loginByPhone(param))
    }

    @AppApi(auth = false)
    @ApiOperation("微信登录")
    @PostMapping("byWechat")
    fun byWechat(@RequestBody @Validated param: RequestLoginWechat): DataResponse<ResponseManagerLogin> {
        return dateResponse(null)
    }
}