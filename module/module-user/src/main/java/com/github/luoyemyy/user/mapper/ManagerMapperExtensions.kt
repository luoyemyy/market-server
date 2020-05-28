package com.github.luoyemyy.user.mapper

import com.github.luoyemyy.user.entity.ManagerRecord
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager.createTime
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager.id
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager.status
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager.updateTime
import com.github.luoyemyy.user.mapper.ManagerDynamicSqlSupport.Manager.userId
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ManagerMapper.count(completer: CountCompleter) =
    countFrom(this::count, Manager, completer)

fun ManagerMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Manager, completer)

fun ManagerMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun ManagerMapper.insert(record: ManagerRecord) =
    insert(this::insert, record, Manager) {
        map(userId).toProperty("userId")
        map(status).toProperty("status")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun ManagerMapper.insertSelective(record: ManagerRecord) =
    insert(this::insert, record, Manager) {
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(status).toPropertyWhenPresent("status", record::status)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, userId, status, createTime, updateTime)

fun ManagerMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Manager, completer)

fun ManagerMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Manager, completer)

fun ManagerMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Manager, completer)

fun ManagerMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun ManagerMapper.update(completer: UpdateCompleter) =
    update(this::update, Manager, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ManagerRecord) =
    apply {
        set(userId).equalTo(record::userId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ManagerRecord) =
    apply {
        set(userId).equalToWhenPresent(record::userId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun ManagerMapper.updateByPrimaryKey(record: ManagerRecord) =
    update {
        set(userId).equalTo(record::userId)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun ManagerMapper.updateByPrimaryKeySelective(record: ManagerRecord) =
    update {
        set(userId).equalToWhenPresent(record::userId)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }