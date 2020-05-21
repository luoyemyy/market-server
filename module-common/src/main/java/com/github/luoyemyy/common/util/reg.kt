package com.github.luoyemyy.common.util

import java.util.regex.*

fun String?.isNumber(): Boolean {
    return RegUtil.match(RegUtil.REG_NUMBER, this)
}

object RegUtil {
    const val REG_NUMBER = "^\\d+$"
    const val REG_PHONE = "^1[34578]\\d{9}$"

    fun match(reg: String?, string: String?): Boolean {
        return if (reg.isNullOrEmpty() || string.isNullOrEmpty()) {
            false
        } else Pattern.compile(reg).matcher(string).matches()
    }

}