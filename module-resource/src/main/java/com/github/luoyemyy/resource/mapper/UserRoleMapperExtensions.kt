package com.github.luoyemyy.resource.mapper

import com.github.luoyemyy.resource.entity.UserRoleRecord
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport.UserRole
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport.UserRole.createTime
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport.UserRole.id
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport.UserRole.roleId
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport.UserRole.status
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport.UserRole.updateTime
import com.github.luoyemyy.resource.mapper.UserRoleDynamicSqlSupport.UserRole.userId
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserRoleMapper.count(completer: CountCompleter) =
    countFrom(this::count, UserRole, completer)

fun UserRoleMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, UserRole, completer)

fun UserRoleMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserRoleMapper.insert(record: UserRoleRecord) =
    insert(this::insert, record, UserRole) {
        map(userId).toProperty("userId")
        map(roleId).toProperty("roleId")
        map(status).toProperty("status")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun UserRoleMapper.insertSelective(record: UserRoleRecord) =
    insert(this::insert, record, UserRole) {
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(roleId).toPropertyWhenPresent("roleId", record::roleId)
        map(status).toPropertyWhenPresent("status", record::status)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, userId, roleId, status, createTime, updateTime)

fun UserRoleMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, UserRole, completer)

fun UserRoleMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, UserRole, completer)

fun UserRoleMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, UserRole, completer)

fun UserRoleMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserRoleMapper.update(completer: UpdateCompleter) =
    update(this::update, UserRole, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRoleRecord) =
    apply {
        set(userId).equalTo(record::userId)
        set(roleId).equalTo(record::roleId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRoleRecord) =
    apply {
        set(userId).equalToWhenPresent(record::userId)
        set(roleId).equalToWhenPresent(record::roleId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun UserRoleMapper.updateByPrimaryKey(record: UserRoleRecord) =
    update {
        set(userId).equalTo(record::userId)
        set(roleId).equalTo(record::roleId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun UserRoleMapper.updateByPrimaryKeySelective(record: UserRoleRecord) =
    update {
        set(userId).equalToWhenPresent(record::userId)
        set(roleId).equalToWhenPresent(record::roleId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }