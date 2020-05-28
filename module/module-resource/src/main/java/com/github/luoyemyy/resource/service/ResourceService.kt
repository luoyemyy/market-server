package com.github.luoyemyy.resource.service

import com.github.luoyemyy.common.advice.AppCode
import com.github.luoyemyy.resource.constants.RoleConstants
import com.github.luoyemyy.resource.entity.ResourceRecord
import com.github.luoyemyy.resource.entity.RoleRecord
import com.github.luoyemyy.resource.mapper.*
import org.mybatis.dynamic.sql.SqlBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ResourceService {

    @Autowired
    private lateinit var resourceMapper: ResourceMapper

    @Transactional
    fun addMenuType(name: String, level: Int, parentId: Long = 0): ResourceRecord {
        val record = ResourceRecord(null, parentId, name, RoleConstants.TYPE_MENU, null, null, level, 1, Date(), Date())
        return add(record)
    }

    @Transactional
    fun addPathType(name: String, pathId: Int, path: String, level: Int, parentId: Long = 0): ResourceRecord {
        val record = ResourceRecord(null, parentId, name, RoleConstants.TYPE_PATH, pathId, path, level, 1, Date(), Date())
        return add(record)
    }

    @Transactional
    fun add(record: ResourceRecord): ResourceRecord {
        if (resourceMapper.insert(record) > 0) {
            return record
        } else {
            throw AppCode.FAIL.throws("保存资源失败")
        }
    }

    @Transactional
    fun edit(id: Long, parentId: Long?, name: String?, pathId: Int?, path: String?, level: Int?): ResourceRecord {
        val record = require(id)
        record.updateTime = Date()
        parentId?.apply {
            record.parentId = this
        }
        name?.apply {
            record.name = this
        }
        pathId?.apply {
            record.pathId = this
        }
        path?.apply {
            record.path = this
        }
        level?.apply {
            record.level = this
        }
        if (resourceMapper.updateByPrimaryKeySelective(record) > 0) {
            return record
        } else {
            throw AppCode.FAIL.throws("修改资源失败，id=${id}")
        }
    }

    @Transactional
    fun delete(id: Long) {
        val record = ResourceRecord(id = id, status = 0, updateTime = Date())
        if (resourceMapper.updateByPrimaryKeySelective(record) == 0) {
            throw AppCode.FAIL.throws("删除资源失败，id=${id}")
        }
    }

    fun require(id: Long): ResourceRecord {
        val record = resourceMapper.selectByPrimaryKey(id)
        val status = record?.status
        if (record == null || status == null || status == 0) {
            throw AppCode.FAIL.throws("不存在该资源，id=${id}")
        } else {
            return record
        }
    }

    fun getByRole(roleId: Long): List<ResourceRecord> {
        return resourceMapper.select {
            join(RoleResourceDynamicSqlSupport.RoleResource, "rr") {
                on(RoleResourceDynamicSqlSupport.RoleResource.resourceId, SqlBuilder.equalTo(ResourceDynamicSqlSupport.Resource.id))
            }
            where(ResourceDynamicSqlSupport.Resource.status, SqlBuilder.isEqualTo(1))
            and(RoleResourceDynamicSqlSupport.RoleResource.status, SqlBuilder.isEqualTo(1))
            and(RoleResourceDynamicSqlSupport.RoleResource.roleId, SqlBuilder.isEqualTo(roleId))
        }
    }

    fun getList(): List<ResourceRecord> {
        return resourceMapper.select {
            where(ResourceDynamicSqlSupport.Resource.status, SqlBuilder.isEqualTo(1))
            orderBy(ResourceDynamicSqlSupport.Resource.type, ResourceDynamicSqlSupport.Resource.pathId)
        }
    }
}