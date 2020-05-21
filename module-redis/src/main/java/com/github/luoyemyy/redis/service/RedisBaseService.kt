package com.github.luoyemyy.redis.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ValueOperations

open class RedisBaseService {

    @Autowired
    protected lateinit var redisTemplate: StringRedisTemplate

    fun hash(): HashOperations<String, String, String> {
        return redisTemplate.opsForHash()
    }

    fun value(): ValueOperations<String, String> {
        return redisTemplate.opsForValue()
    }
}