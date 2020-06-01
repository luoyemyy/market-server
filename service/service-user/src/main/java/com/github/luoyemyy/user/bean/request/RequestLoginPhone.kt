package com.github.luoyemyy.user.bean.request

import com.github.luoyemyy.common.valid.ValidString
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("手机号验证码登录参数")
class RequestLoginPhone : RequestLogin() {

    @ValidString
    @ApiModelProperty(value = "手机号", required = true)
    var phone: String = ""

    @ValidString
    @ApiModelProperty(value = "验证码", required = true)
    var code: String = ""
}