package com.github.luoyemyy.user.service

import com.github.luoyemyy.user.entity.UserTokenRecord
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.token
import com.github.luoyemyy.user.mapper.UserTokenMapper
import com.github.luoyemyy.user.mapper.selectOne
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserTokenService {

    @Autowired
    private lateinit var userTokenMapper: UserTokenMapper

    fun getByToken(token0: String): UserTokenRecord? {
        return userTokenMapper.selectOne {
            where(token, isEqualTo(token0))
            limit(1)
        }
    }
}