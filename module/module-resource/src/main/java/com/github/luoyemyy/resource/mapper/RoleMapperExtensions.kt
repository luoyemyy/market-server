package com.github.luoyemyy.resource.mapper

import com.github.luoyemyy.resource.entity.RoleRecord
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport.Role
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport.Role.createTime
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport.Role.id
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport.Role.isAdmin
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport.Role.name
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport.Role.status
import com.github.luoyemyy.resource.mapper.RoleDynamicSqlSupport.Role.updateTime
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun RoleMapper.count(completer: CountCompleter) =
    countFrom(this::count, Role, completer)

fun RoleMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Role, completer)

fun RoleMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun RoleMapper.insert(record: RoleRecord) =
    insert(this::insert, record, Role) {
        map(name).toProperty("name")
        map(isAdmin).toProperty("isAdmin")
        map(status).toProperty("status")
        map(updateTime).toProperty("updateTime")
        map(createTime).toProperty("createTime")
    }

fun RoleMapper.insertSelective(record: RoleRecord) =
    insert(this::insert, record, Role) {
        map(name).toPropertyWhenPresent("name", record::name)
        map(isAdmin).toPropertyWhenPresent("isAdmin", record::isAdmin)
        map(status).toPropertyWhenPresent("status", record::status)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
    }

private val columnList = listOf(id, name, isAdmin, status, updateTime, createTime)

fun RoleMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Role, completer)

fun RoleMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Role, completer)

fun RoleMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Role, completer)

fun RoleMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun RoleMapper.update(completer: UpdateCompleter) =
    update(this::update, Role, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: RoleRecord) =
    apply {
        set(name).equalTo(record::name)
        set(isAdmin).equalTo(record::isAdmin)
        set(status).equalTo(record::status)
        set(updateTime).equalTo(record::updateTime)
        set(createTime).equalTo(record::createTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: RoleRecord) =
    apply {
        set(name).equalToWhenPresent(record::name)
        set(isAdmin).equalToWhenPresent(record::isAdmin)
        set(status).equalToWhenPresent(record::status)
        set(updateTime).equalToWhenPresent(record::updateTime)
        set(createTime).equalToWhenPresent(record::createTime)
    }

fun RoleMapper.updateByPrimaryKey(record: RoleRecord) =
    update {
        set(name).equalTo(record::name)
        set(isAdmin).equalTo(record::isAdmin)
        set(status).equalTo(record::status)
        set(updateTime).equalTo(record::updateTime)
        set(createTime).equalTo(record::createTime)
        where(id, isEqualTo(record::id))
    }

fun RoleMapper.updateByPrimaryKeySelective(record: RoleRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(isAdmin).equalToWhenPresent(record::isAdmin)
        set(status).equalToWhenPresent(record::status)
        set(updateTime).equalToWhenPresent(record::updateTime)
        set(createTime).equalToWhenPresent(record::createTime)
        where(id, isEqualTo(record::id))
    }