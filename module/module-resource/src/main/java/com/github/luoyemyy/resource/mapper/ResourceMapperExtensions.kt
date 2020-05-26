package com.github.luoyemyy.resource.mapper

import com.github.luoyemyy.resource.entity.ResourceRecord
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.createTime
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.id
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.level
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.name
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.parentLevel
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.path
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.pathId
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.status
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.type
import com.github.luoyemyy.resource.mapper.ResourceDynamicSqlSupport.Resource.updateTime
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ResourceMapper.count(completer: CountCompleter) =
    countFrom(this::count, Resource, completer)

fun ResourceMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Resource, completer)

fun ResourceMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun ResourceMapper.insert(record: ResourceRecord) =
    insert(this::insert, record, Resource) {
        map(name).toProperty("name")
        map(type).toProperty("type")
        map(pathId).toProperty("pathId")
        map(path).toProperty("path")
        map(level).toProperty("level")
        map(parentLevel).toProperty("parentLevel")
        map(status).toProperty("status")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun ResourceMapper.insertSelective(record: ResourceRecord) =
    insert(this::insert, record, Resource) {
        map(name).toPropertyWhenPresent("name", record::name)
        map(type).toPropertyWhenPresent("type", record::type)
        map(pathId).toPropertyWhenPresent("pathId", record::pathId)
        map(path).toPropertyWhenPresent("path", record::path)
        map(level).toPropertyWhenPresent("level", record::level)
        map(parentLevel).toPropertyWhenPresent("parentLevel", record::parentLevel)
        map(status).toPropertyWhenPresent("status", record::status)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, name, type, pathId, path, level, parentLevel, status, createTime, updateTime)

fun ResourceMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Resource, completer)

fun ResourceMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Resource, completer)

fun ResourceMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Resource, completer)

fun ResourceMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun ResourceMapper.update(completer: UpdateCompleter) =
    update(this::update, Resource, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ResourceRecord) =
    apply {
        set(name).equalTo(record::name)
        set(type).equalTo(record::type)
        set(pathId).equalTo(record::pathId)
        set(path).equalTo(record::path)
        set(level).equalTo(record::level)
        set(parentLevel).equalTo(record::parentLevel)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ResourceRecord) =
    apply {
        set(name).equalToWhenPresent(record::name)
        set(type).equalToWhenPresent(record::type)
        set(pathId).equalToWhenPresent(record::pathId)
        set(path).equalToWhenPresent(record::path)
        set(level).equalToWhenPresent(record::level)
        set(parentLevel).equalToWhenPresent(record::parentLevel)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun ResourceMapper.updateByPrimaryKey(record: ResourceRecord) =
    update {
        set(name).equalTo(record::name)
        set(type).equalTo(record::type)
        set(pathId).equalTo(record::pathId)
        set(path).equalTo(record::path)
        set(level).equalTo(record::level)
        set(parentLevel).equalTo(record::parentLevel)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun ResourceMapper.updateByPrimaryKeySelective(record: ResourceRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(type).equalToWhenPresent(record::type)
        set(pathId).equalToWhenPresent(record::pathId)
        set(path).equalToWhenPresent(record::path)
        set(level).equalToWhenPresent(record::level)
        set(parentLevel).equalToWhenPresent(record::parentLevel)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }