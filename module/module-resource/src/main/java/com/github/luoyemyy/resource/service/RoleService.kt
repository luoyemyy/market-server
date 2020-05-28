package com.github.luoyemyy.resource.service

import com.github.luoyemyy.common.advice.AppCode
import com.github.luoyemyy.resource.entity.RoleRecord
import com.github.luoyemyy.resource.entity.RoleResourceRecord
import com.github.luoyemyy.resource.mapper.*
import org.mybatis.dynamic.sql.SqlBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class RoleService {

    @Autowired
    private lateinit var roleMapper: RoleMapper

    @Autowired
    private lateinit var roleResourceMapper: RoleResourceMapper

    @Autowired
    private lateinit var resourceService: ResourceService

    @Transactional
    fun add(name: String): RoleRecord {
        val role = RoleRecord(name = name, status = 1, createTime = Date(), updateTime = Date())
        if (roleMapper.insert(role) > 0) {
            return role
        } else {
            throw AppCode.FAIL.throws("保存角色失败")
        }
    }

    @Transactional
    fun addRoleResource(roleId: Long, role0: RoleRecord?, resourceIds: List<Long>) {
        val role = role0 ?: require(roleId)
        resourceIds.forEach {
            roleResourceMapper.insert(RoleResourceRecord(null, role.id, it, 1, Date(), Date()))
        }
    }

    @Transactional
    fun edit(roleId: Long, name: String?, status: Int?): RoleRecord {
        val role = require(roleId)
        name?.apply {
            role.name = name
        }
        status?.apply {
            role.status = status
        }
        role.updateTime = Date()
        if (roleMapper.updateByPrimaryKeySelective(role) > 0) {
            return role
        } else {
            throw AppCode.FAIL.throws("编辑角色失败")
        }
    }

    @Transactional
    fun editRoleResource(roleId: Long, role0: RoleRecord?, resourceIds: List<Long>) {
        val role = role0 ?: require(roleId)
        val oldResourceIds = resourceService.getByRole(roleId).mapNotNull { it.id }
        val addIds = resourceIds.minus(oldResourceIds)
        val deleteIds = oldResourceIds.minus(resourceIds)
        addIds.forEach {
            roleResourceMapper.insert(RoleResourceRecord(null, role.id, it, 1, Date(), Date()))
        }
        roleResourceMapper.delete {
            where(RoleResourceDynamicSqlSupport.RoleResource.id, SqlBuilder.isIn(deleteIds))
        }
    }

    fun require(id: Long): RoleRecord {
        val record = roleMapper.selectByPrimaryKey(id)
        val status = record?.status
        if (record == null || status == null || status == 0) {
            throw AppCode.FAIL.throws("不存在该角色，id=${id}")
        } else {
            return record
        }
    }

    fun getList(): List<RoleRecord> {
        return roleMapper.select {
            where(RoleDynamicSqlSupport.Role.status, SqlBuilder.isEqualTo(1))
        }
    }

    fun getByManager(managerId: Long): List<RoleRecord> {
        return roleMapper.select {
            join(ManagerRoleDynamicSqlSupport.ManagerRole, "ur") {
                on(ManagerRoleDynamicSqlSupport.ManagerRole.roleId, SqlBuilder.equalTo(RoleDynamicSqlSupport.Role.id))
            }
            where(ManagerRoleDynamicSqlSupport.ManagerRole.status, SqlBuilder.isEqualTo(1))
            and(RoleDynamicSqlSupport.Role.status, SqlBuilder.isEqualTo(1))
            and(ManagerRoleDynamicSqlSupport.ManagerRole.managerId, SqlBuilder.isEqualTo(managerId))
        }
    }
}