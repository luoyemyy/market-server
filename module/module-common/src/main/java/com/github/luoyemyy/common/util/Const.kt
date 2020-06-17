package com.github.luoyemyy.common.util

object Const {

    const val TOKEN = "token"

    object ServiceType {
        const val PLATFORM = "platform"
        const val MERCHANT = "merchant"
        const val CONSUMER = "consumer"
        fun all(): Array<String> = arrayOf(PLATFORM, MERCHANT, CONSUMER)
    }

    object Client {
        const val WEB = "WEB"
        const val IOS = "IOS"
        const val ANDROID = "ANDROID"
        const val MINI_PROGRAM = "MINI_PROGRAM"
        const val WE_CHAT = "WE_CHAT"
        fun all(): Array<String> = arrayOf(WEB, IOS, ANDROID, MINI_PROGRAM, WE_CHAT)
    }
}