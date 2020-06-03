package com.github.luoyemyy.redis.service

import com.github.luoyemyy.common.util.toJsonString
import com.github.luoyemyy.common.util.toObject
import com.github.luoyemyy.redis.bean.CacheManagerInfo
import com.github.luoyemyy.redis.bean.CacheUserInfo
import com.github.luoyemyy.redis.constants.RedisKey
import com.github.luoyemyy.redis.constants.RedisScripts
import org.springframework.data.redis.core.script.DefaultRedisScript
import org.springframework.stereotype.Service

@Service
class RedisUserService : RedisBaseService() {

    fun getByToken(token: String?): CacheUserInfo? {
        return token?.let {
            redisTemplate.execute(
                    DefaultRedisScript(RedisScripts.USER_INFO_BY_TOKEN, String::class.java),
                    mutableListOf(it, RedisKey.LOGIN_TOKEN, RedisKey.USER_INFO)
            ).toObject()
        }
    }

    fun getByUser(userId: Long): CacheUserInfo? {
        return hash().get(RedisKey.USER_INFO, userId)?.toObject()
    }

    fun cacheUserInfo(userInfo: CacheUserInfo?): Boolean {
        val loginTokenKey = toByte(RedisKey.LOGIN_TOKEN) ?: return false
        val userInfoKey = toByte(RedisKey.USER_INFO) ?: return false
        val token = toByte(userInfo?.token) ?: return false
        val userId = toByte(userInfo?.userId) ?: return false
        val userInfoJson = toByte(userInfo.toJsonString()) ?: return false
        redisTemplate.executePipelined {
            it.hashCommands().hSet(loginTokenKey, token, userId)
            it.hashCommands().hSet(userInfoKey, userId, userInfoJson)
        }
        return true
    }
}