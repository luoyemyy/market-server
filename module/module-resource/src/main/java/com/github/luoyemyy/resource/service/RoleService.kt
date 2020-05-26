package com.github.luoyemyy.resource.service

import com.github.luoyemyy.resource.entity.RoleRecord
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport
import com.github.luoyemyy.resource.mapper.RoleMapper
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport
import com.github.luoyemyy.resource.mapper.select
import org.mybatis.dynamic.sql.SqlBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoleService {

    @Autowired
    private lateinit var roleMapper: RoleMapper

    fun getRoleByType(type: Int): List<RoleRecord> {
        return roleMapper.select {
            where(RoleDynamicSqlSupport.Role.status, SqlBuilder.isEqualTo(1))
            and(RoleDynamicSqlSupport.Role.type, SqlBuilder.isEqualTo(type))
        }
    }

    fun getRoleByUser(userId: Long): List<RoleRecord> {
        return roleMapper.select {
            join(UserRoleDynamicSqlSupport.UserRole, "ur") {
                on(UserRoleDynamicSqlSupport.UserRole.roleId, SqlBuilder.equalTo(RoleDynamicSqlSupport.Role.id))
            }
            where(UserRoleDynamicSqlSupport.UserRole.status, SqlBuilder.isEqualTo(1))
            and(RoleDynamicSqlSupport.Role.status, SqlBuilder.isEqualTo(1))
            and(UserRoleDynamicSqlSupport.UserRole.userId, SqlBuilder.isEqualTo(userId))
        }
    }
}