package com.github.luoyemyy.auth.controller

import com.github.luoyemyy.auth.bean.request.RequestLoginPhone
import com.github.luoyemyy.auth.bean.request.RequestLoginUsername
import com.github.luoyemyy.auth.bean.request.RequestLoginWechat
import com.github.luoyemyy.auth.bean.response.ResponseLogin
import com.github.luoyemyy.common.aspect.AppApi
import com.github.luoyemyy.common.swagger.DataResponse
import com.github.luoyemyy.common.swagger.dateResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["登录"])
@RestController
@RequestMapping("api/auth/login")
class LoginController {

    @AppApi(auth = false)
    @ApiOperation("用户名密码登录")
    @PostMapping("byUsername")
    fun byUsername(@RequestBody @Validated param: RequestLoginUsername): DataResponse<ResponseLogin> {
        return dateResponse(null)
    }

    @AppApi(auth = false)
    @ApiOperation("手机号验证码登录")
    @PostMapping("byPhone")
    fun byPhone(@RequestBody @Validated param: RequestLoginPhone): DataResponse<ResponseLogin> {
        return dateResponse(null)
    }

    @AppApi(auth = false)
    @ApiOperation("微信登录")
    @PostMapping("byWechat")
    fun byWechat(@RequestBody @Validated param: RequestLoginWechat): DataResponse<ResponseLogin> {
        return dateResponse(null)
    }
}