package com.github.luoyemyy.redis.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.*

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

//    fun cas(key: String, except: String, update: String): Boolean {
//        return redisTemplate.execute(RedisScript.of())
//    }
}