package com.github.luoyemyy.redis.service

import com.github.luoyemyy.redis.constants.RedisKey
import com.github.luoyemyy.redis.constants.RedisScripts
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.*
import org.springframework.data.redis.core.script.DefaultRedisScript

open class RedisBaseService {

    @Autowired
    protected lateinit var redisTemplate: StringRedisTemplate

    fun hash(): HashOperations<String, String, String> {
        return redisTemplate.opsForHash()
    }

    fun set(): SetOperations<String, String> {
        return redisTemplate.opsForSet()
    }

    fun list(): ListOperations<String, String> {
        return redisTemplate.opsForList()
    }

    fun value(): ValueOperations<String, String> {
        return redisTemplate.opsForValue()
    }

    /**
     * @return update or null
     */
    fun cas(key: String, except: String, update: String): String? {
        return redisTemplate.execute(DefaultRedisScript(RedisScripts.CAS, String::class.java), mutableListOf(key), except, update)
    }

    /**
     * @return CacheUserInfo or null
     */
    fun getUserInfoByToken(token: String): String? {
        return redisTemplate.execute(DefaultRedisScript(RedisScripts.USER_INFO_BY_TOKEN, String::class.java), mutableListOf(token, RedisKey.LOGIN_TOKEN, RedisKey.USER_INFO))
    }
}