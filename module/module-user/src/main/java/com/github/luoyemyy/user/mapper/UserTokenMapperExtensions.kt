package com.github.luoyemyy.user.mapper

import com.github.luoyemyy.user.entity.UserTokenRecord
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.client
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.createTime
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.id
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.token
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.tokenExpire
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.updateTime
import com.github.luoyemyy.user.mapper.UserTokenDynamicSqlSupport.UserToken.userId
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserTokenMapper.count(completer: CountCompleter) =
    countFrom(this::count, UserToken, completer)

fun UserTokenMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, UserToken, completer)

fun UserTokenMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserTokenMapper.insert(record: UserTokenRecord) =
    insert(this::insert, record, UserToken) {
        map(userId).toProperty("userId")
        map(client).toProperty("client")
        map(token).toProperty("token")
        map(tokenExpire).toProperty("tokenExpire")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun UserTokenMapper.insertSelective(record: UserTokenRecord) =
    insert(this::insert, record, UserToken) {
        map(userId).toPropertyWhenPresent("userId", record::userId)
        map(client).toPropertyWhenPresent("client", record::client)
        map(token).toPropertyWhenPresent("token", record::token)
        map(tokenExpire).toPropertyWhenPresent("tokenExpire", record::tokenExpire)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, userId, client, token, tokenExpire, createTime, updateTime)

fun UserTokenMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, UserToken, completer)

fun UserTokenMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, UserToken, completer)

fun UserTokenMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, UserToken, completer)

fun UserTokenMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserTokenMapper.update(completer: UpdateCompleter) =
    update(this::update, UserToken, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserTokenRecord) =
    apply {
        set(userId).equalTo(record::userId)
        set(client).equalTo(record::client)
        set(token).equalTo(record::token)
        set(tokenExpire).equalTo(record::tokenExpire)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserTokenRecord) =
    apply {
        set(userId).equalToWhenPresent(record::userId)
        set(client).equalToWhenPresent(record::client)
        set(token).equalToWhenPresent(record::token)
        set(tokenExpire).equalToWhenPresent(record::tokenExpire)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun UserTokenMapper.updateByPrimaryKey(record: UserTokenRecord) =
    update {
        set(userId).equalTo(record::userId)
        set(client).equalTo(record::client)
        set(token).equalTo(record::token)
        set(tokenExpire).equalTo(record::tokenExpire)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun UserTokenMapper.updateByPrimaryKeySelective(record: UserTokenRecord) =
    update {
        set(userId).equalToWhenPresent(record::userId)
        set(client).equalToWhenPresent(record::client)
        set(token).equalToWhenPresent(record::token)
        set(tokenExpire).equalToWhenPresent(record::tokenExpire)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }