package com.github.luoyemyy.common.bean

import com.github.luoyemyy.common.advice.AppCode
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("请求结果")
open class Response(appCode: AppCode) {
    @ApiModelProperty("0 成功； 其他 失败 ")
    var code: Int = appCode.code

    @ApiModelProperty("错误码描述")
    var codeMsg: String? = appCode.msg

    @ApiModelProperty("业务错误描述")
    var errorMsg: String? = null

    constructor() : this(AppCode.OK)
}

class DataResponse<T>(@ApiModelProperty("返回对象") var data: T? = null) : Response()

class ListResponse<T>(@ApiModelProperty("返回列表") var list: List<T>? = null) : Response()

class IdResponse(@ApiModelProperty("返回主键") var id: Long = 0) : Response()

class AlertResponse(@ApiModelProperty("返回信息") var alert: String? = null) : Response()

fun <T> dateResponse(data: T?): DataResponse<T> {
    return DataResponse(data)
}

fun <T> listResponse(list: List<T>?): ListResponse<T> {
    return ListResponse(list)
}

fun response(): Response {
    return Response()
}

fun response(ok: Boolean): Response {
    return Response(if (ok) AppCode.OK else AppCode.FAIL)
}

