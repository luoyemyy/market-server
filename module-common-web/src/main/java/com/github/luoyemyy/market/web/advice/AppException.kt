@file:Suppress("unused", "CanBeParameter")

package com.github.luoyemyy.market.web.advice

class AppException(private val appCode: AppCode,
                   private val errorMsg: String? = null,
                   private val throwable: Throwable? = null) : RuntimeException(appCode.msg, throwable) {

    fun code(): Int {
        return appCode.code
    }

    fun codeMsg(): String? {
        return appCode.msg
    }

    fun errorMsg(): String? {
        return errorMsg
    }

    fun cause(): Throwable? {
        return throwable
    }
}