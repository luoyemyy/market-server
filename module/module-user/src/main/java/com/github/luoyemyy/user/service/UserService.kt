package com.github.luoyemyy.user.service

import com.github.luoyemyy.redis.service.RedisUserService
import com.github.luoyemyy.user.entity.UserRecord
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.phone
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.status
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.username
import com.github.luoyemyy.user.mapper.UserMapper
import com.github.luoyemyy.user.mapper.selectByPrimaryKey
import com.github.luoyemyy.user.mapper.selectOne
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    @Autowired
    private lateinit var userTokenService: UserTokenService

    @Autowired
    private lateinit var redisUserService: RedisUserService

    fun getByUsername(username0: String): UserRecord? {
        return userMapper.selectOne {
            where(status, isEqualTo(1))
            and(username, isEqualTo(username0))
            limit(1)
        }
    }

    fun getByPhone(phone0: String): UserRecord? {
        return userMapper.selectOne {
            where(status, isEqualTo(1))
            and(phone, isEqualTo(phone0))
            limit(1)
        }
    }

    fun getByToken(token: String): UserRecord? {
        return userTokenService.getByToken(token)?.userId?.let {
            userMapper.selectByPrimaryKey(it)
        }
    }
}