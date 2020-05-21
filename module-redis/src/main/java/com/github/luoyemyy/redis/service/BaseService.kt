package com.github.luoyemyy.redis.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class BaseService {
    @Autowired
    private lateinit var stringRedisTemplate: StringRedisTemplate
}