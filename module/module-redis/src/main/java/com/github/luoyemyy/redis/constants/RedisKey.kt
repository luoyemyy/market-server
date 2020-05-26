package com.github.luoyemyy.redis.constants

object RedisKey {

    fun userInfo(userId: Long): String {
        return "userInfo_$userId"
    }

    fun role(roleId: Long): String {
        return "role_$roleId"
    }
}