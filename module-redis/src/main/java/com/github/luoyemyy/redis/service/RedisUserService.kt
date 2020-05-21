package com.github.luoyemyy.redis.service

import com.github.luoyemyy.redis.bean.CacheUserInfo
import com.github.luoyemyy.redis.constants.RedisKey
import org.springframework.stereotype.Service

@Service
class RedisUserService : RedisBaseService() {

    /**
     * 获得指定用户的信息
     */
    fun getUserInfo(userId: Long): CacheUserInfo? {
        return CacheUserInfo.mapOf(hash().multiGet(RedisKey.userInfo(userId), CacheUserInfo.ALL_KEYS))
    }

    /**
     * 获得指定用户的所有角色
     */
    fun getUserRole(userId: Long): List<Long> {
        return CacheUserInfo.mapRole(hash().get(RedisKey.userInfo(userId), CacheUserInfo.ROLE))
    }
}