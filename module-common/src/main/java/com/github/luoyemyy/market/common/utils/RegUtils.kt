@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.github.luoyemyy.market.common.utils

import java.util.regex.*

object RegUtils {
    const val REG_NUMBER = "^\\d+$"

    fun match(reg: String?, string: String?): Boolean {
        return if (reg.isNullOrEmpty() || string.isNullOrEmpty()) {
            false
        } else Pattern.compile(reg).matcher(string).matches()
    }

    fun isNumber(string: String?): Boolean {
        return match(REG_NUMBER, string)
    }
}