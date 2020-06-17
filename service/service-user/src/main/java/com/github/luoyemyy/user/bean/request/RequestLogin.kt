package com.github.luoyemyy.user.bean.request

import com.github.luoyemyy.common.util.Const
import com.github.luoyemyy.common.valid.ValidString
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel
open class RequestLogin {

    @ValidString(values = [Const.Client.IOS, Const.Client.ANDROID, Const.Client.WEB, Const.Client.MINI_PROGRAM, Const.Client.WE_CHAT])
    @ApiModelProperty(value = "客户端类型：IOS,ANDROID,WEB,MINI_PROGRAM,WE_CHAT", required = true)
    var client: String = ""

    @ValidString
    @ApiModelProperty(value = "版本号", required = true)
    var version: String = ""

    @ValidString(values = [Const.ServiceType.PLATFORM, Const.ServiceType.MERCHANT, Const.ServiceType.CONSUMER])
    @ApiModelProperty(value = "服务类型：platform 平台, merchant 商户, consumer 消费者", required = true)
    var serviceType: String = ""


}