package com.github.luoyemyy.common.swagger

import com.github.luoyemyy.common.advice.AppCode
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("请求结果")
open class ApiResponse(appCode: AppCode) {
    @ApiModelProperty("0 成功； 其他 失败 ")
    var code: Int = appCode.code

    @ApiModelProperty("错误码描述")
    var codeMsg: String? = appCode.msg

    @ApiModelProperty("业务错误描述")
    var errorMsg: String? = null

    constructor() : this(AppCode.OK)
}

class DataResponse<T>(@ApiModelProperty("返回对象") var data: T? = null) : ApiResponse()

class ListResponse<T>(@ApiModelProperty("返回列表") var list: List<T>? = null) : ApiResponse()

class IdResponse(@ApiModelProperty("返回主键") var id: Long = 0) : ApiResponse()

class AlertResponse(@ApiModelProperty("返回信息") var alert: String? = null) : ApiResponse()

fun <T> response(data: T?): DataResponse<T> {
    return DataResponse(data)
}

fun <T> response(list: List<T>?): ListResponse<T> {
    return ListResponse(list)
}

fun response(): ApiResponse {
    return ApiResponse()
}

fun response(ok: Boolean): ApiResponse {
    return ApiResponse(if (ok) AppCode.OK else AppCode.FAIL)
}

