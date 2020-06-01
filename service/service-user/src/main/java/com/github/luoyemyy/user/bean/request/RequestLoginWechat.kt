package com.github.luoyemyy.user.bean.request

import com.github.luoyemyy.common.valid.ValidString
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("微信登录参数")
class RequestLoginWechat : RequestLogin() {

    @ValidString
    @ApiModelProperty(value = "原始id", required = true)
    var uniqueId: String = ""

    @ValidString
    @ApiModelProperty(value = "授权码", required = true)
    var code: String = ""
}