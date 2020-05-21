package com.github.luoyemyy.common.advice

enum class AppCode(val code: Int, val msg: String?) {

    OK(0, "ok"),
    FAIL(-1, "fail"),
    ERROR_PARAM(100, "参数错误");


    fun throws(errorMsg: String? = null, throwable: Throwable? = null): AppException {
        return AppException(this, errorMsg, throwable)
    }

}