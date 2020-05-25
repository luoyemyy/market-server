package com.github.luoyemyy.resource.mapper

import com.github.luoyemyy.resource.entity.RoleResourceRecord
import com.github.luoyemyy.resource.mapper.RoleResourceDynamicSqlSupport.RoleResource
import com.github.luoyemyy.resource.mapper.RoleResourceDynamicSqlSupport.RoleResource.createTime
import com.github.luoyemyy.resource.mapper.RoleResourceDynamicSqlSupport.RoleResource.id
import com.github.luoyemyy.resource.mapper.RoleResourceDynamicSqlSupport.RoleResource.resourceId
import com.github.luoyemyy.resource.mapper.RoleResourceDynamicSqlSupport.RoleResource.roleId
import com.github.luoyemyy.resource.mapper.RoleResourceDynamicSqlSupport.RoleResource.status
import com.github.luoyemyy.resource.mapper.RoleResourceDynamicSqlSupport.RoleResource.updateTime
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun RoleResourceMapper.count(completer: CountCompleter) =
    countFrom(this::count, RoleResource, completer)

fun RoleResourceMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, RoleResource, completer)

fun RoleResourceMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun RoleResourceMapper.insert(record: RoleResourceRecord) =
    insert(this::insert, record, RoleResource) {
        map(roleId).toProperty("roleId")
        map(resourceId).toProperty("resourceId")
        map(status).toProperty("status")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun RoleResourceMapper.insertSelective(record: RoleResourceRecord) =
    insert(this::insert, record, RoleResource) {
        map(roleId).toPropertyWhenPresent("roleId", record::roleId)
        map(resourceId).toPropertyWhenPresent("resourceId", record::resourceId)
        map(status).toPropertyWhenPresent("status", record::status)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, roleId, resourceId, status, createTime, updateTime)

fun RoleResourceMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, RoleResource, completer)

fun RoleResourceMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, RoleResource, completer)

fun RoleResourceMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, RoleResource, completer)

fun RoleResourceMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun RoleResourceMapper.update(completer: UpdateCompleter) =
    update(this::update, RoleResource, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: RoleResourceRecord) =
    apply {
        set(roleId).equalTo(record::roleId)
        set(resourceId).equalTo(record::resourceId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: RoleResourceRecord) =
    apply {
        set(roleId).equalToWhenPresent(record::roleId)
        set(resourceId).equalToWhenPresent(record::resourceId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun RoleResourceMapper.updateByPrimaryKey(record: RoleResourceRecord) =
    update {
        set(roleId).equalTo(record::roleId)
        set(resourceId).equalTo(record::resourceId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun RoleResourceMapper.updateByPrimaryKeySelective(record: RoleResourceRecord) =
    update {
        set(roleId).equalToWhenPresent(record::roleId)
        set(resourceId).equalToWhenPresent(record::resourceId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }