package com.github.luoyemyy.common.advice

enum class AppCode(val code: Int, val msg: String?) {

    OK(0, "ok"),
    FAIL(-1, "fail"),
    ERROR_PARAM(100, "参数错误"),
    ERROR_USERNAME_PASSWORD(101, "用户名或密码错误"),
    ERROR_PHONE_CODE(102, "验证码错误"),
    ERROR_PHONE_EXISTS(104, "手机号已存在");


    fun throws(errorMsg: String? = null, throwable: Throwable? = null): AppException {
        return AppException(this, errorMsg, throwable)
    }

}