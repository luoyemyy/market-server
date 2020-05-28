package com.github.luoyemyy.user.service

import com.github.luoyemyy.user.entity.ManagerRecord
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager.status
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager.userId
import com.github.luoyemyy.user.mapper.ManagerMapper
import com.github.luoyemyy.user.mapper.select
import com.github.luoyemyy.user.mapper.selectOne
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ManagerService {

    @Autowired
    private lateinit var managerMapper: ManagerMapper

    fun getByUser(userId0: Long): ManagerRecord? {
        return managerMapper.selectOne {
            where(status, isEqualTo(1))
            and(userId, isEqualTo(userId0))
            limit(1)
        }
    }

    fun getByPage(pageStart: Int, pageSize: Int): List<ManagerRecord> {
        return managerMapper.select {
            where(status, isEqualTo(1))
            offset(pageStart.toLong())
            limit(pageSize.toLong())
        }
    }

}