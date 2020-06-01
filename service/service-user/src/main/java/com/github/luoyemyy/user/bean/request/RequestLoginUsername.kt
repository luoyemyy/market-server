package com.github.luoyemyy.user.bean.request

import com.github.luoyemyy.common.valid.ValidString
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("用户名密码登录参数")
class RequestLoginUsername : RequestLogin() {

    @ValidString
    @ApiModelProperty(value = "用户名", required = true)
    var username: String = ""

    @ValidString
    @ApiModelProperty(value = "密码", required = true)
    var password: String = ""
}