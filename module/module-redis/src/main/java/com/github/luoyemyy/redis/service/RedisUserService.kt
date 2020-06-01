package com.github.luoyemyy.redis.service

import com.github.luoyemyy.common.util.toObject
import com.github.luoyemyy.redis.bean.CacheUserInfo
import com.github.luoyemyy.redis.constants.RedisKey
import org.springframework.stereotype.Service

@Service
class RedisUserService : RedisBaseService() {


    /**
     * 获得指定用户的信息
     */
    fun getUserInfo(userId: Long): CacheUserInfo? {
        return hash().get(RedisKey.USER_INFO, userId.toString()).toObject()
    }

}