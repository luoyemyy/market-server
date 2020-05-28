package com.github.luoyemyy.resource.mapper

import com.github.luoyemyy.resource.entity.ManagerRoleRecord
import com.github.luoyemyy.resource.mapper.ManagerRoleDynamicSqlSupport.ManagerRole
import com.github.luoyemyy.resource.mapper.ManagerRoleDynamicSqlSupport.ManagerRole.createTime
import com.github.luoyemyy.resource.mapper.ManagerRoleDynamicSqlSupport.ManagerRole.id
import com.github.luoyemyy.resource.mapper.ManagerRoleDynamicSqlSupport.ManagerRole.managerId
import com.github.luoyemyy.resource.mapper.ManagerRoleDynamicSqlSupport.ManagerRole.roleId
import com.github.luoyemyy.resource.mapper.ManagerRoleDynamicSqlSupport.ManagerRole.status
import com.github.luoyemyy.resource.mapper.ManagerRoleDynamicSqlSupport.ManagerRole.updateTime
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ManagerRoleMapper.count(completer: CountCompleter) =
    countFrom(this::count, ManagerRole, completer)

fun ManagerRoleMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, ManagerRole, completer)

fun ManagerRoleMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun ManagerRoleMapper.insert(record: ManagerRoleRecord) =
    insert(this::insert, record, ManagerRole) {
        map(roleId).toProperty("roleId")
        map(managerId).toProperty("managerId")
        map(status).toProperty("status")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun ManagerRoleMapper.insertSelective(record: ManagerRoleRecord) =
    insert(this::insert, record, ManagerRole) {
        map(roleId).toPropertyWhenPresent("roleId", record::roleId)
        map(managerId).toPropertyWhenPresent("managerId", record::managerId)
        map(status).toPropertyWhenPresent("status", record::status)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, roleId, managerId, status, createTime, updateTime)

fun ManagerRoleMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, ManagerRole, completer)

fun ManagerRoleMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, ManagerRole, completer)

fun ManagerRoleMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, ManagerRole, completer)

fun ManagerRoleMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun ManagerRoleMapper.update(completer: UpdateCompleter) =
    update(this::update, ManagerRole, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ManagerRoleRecord) =
    apply {
        set(roleId).equalTo(record::roleId)
        set(managerId).equalTo(record::managerId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ManagerRoleRecord) =
    apply {
        set(roleId).equalToWhenPresent(record::roleId)
        set(managerId).equalToWhenPresent(record::managerId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun ManagerRoleMapper.updateByPrimaryKey(record: ManagerRoleRecord) =
    update {
        set(roleId).equalTo(record::roleId)
        set(managerId).equalTo(record::managerId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun ManagerRoleMapper.updateByPrimaryKeySelective(record: ManagerRoleRecord) =
    update {
        set(roleId).equalToWhenPresent(record::roleId)
        set(managerId).equalToWhenPresent(record::managerId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }