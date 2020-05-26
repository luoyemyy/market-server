package com.github.luoyemyy.user.mapper

import com.github.luoyemyy.user.entity.UserRecord
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.createTime
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.headImg
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.id
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.nickname
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.password
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.phone
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.status
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.updateTime
import com.github.luoyemyy.user.mapper.UserDynamicSqlSupport.User.username
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(nickname).toProperty("nickname")
        map(headImg).toProperty("headImg")
        map(username).toProperty("username")
        map(phone).toProperty("phone")
        map(password).toProperty("password")
        map(status).toProperty("status")
        map(createTime).toProperty("createTime")
        map(updateTime).toProperty("updateTime")
    }

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(nickname).toPropertyWhenPresent("nickname", record::nickname)
        map(headImg).toPropertyWhenPresent("headImg", record::headImg)
        map(username).toPropertyWhenPresent("username", record::username)
        map(phone).toPropertyWhenPresent("phone", record::phone)
        map(password).toPropertyWhenPresent("password", record::password)
        map(status).toPropertyWhenPresent("status", record::status)
        map(createTime).toPropertyWhenPresent("createTime", record::createTime)
        map(updateTime).toPropertyWhenPresent("updateTime", record::updateTime)
    }

private val columnList = listOf(id, nickname, headImg, username, phone, password, status, createTime, updateTime)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(nickname).equalTo(record::nickname)
        set(headImg).equalTo(record::headImg)
        set(username).equalTo(record::username)
        set(phone).equalTo(record::phone)
        set(password).equalTo(record::password)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(nickname).equalToWhenPresent(record::nickname)
        set(headImg).equalToWhenPresent(record::headImg)
        set(username).equalToWhenPresent(record::username)
        set(phone).equalToWhenPresent(record::phone)
        set(password).equalToWhenPresent(record::password)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(nickname).equalTo(record::nickname)
        set(headImg).equalTo(record::headImg)
        set(username).equalTo(record::username)
        set(phone).equalTo(record::phone)
        set(password).equalTo(record::password)
        set(status).equalTo(record::status)
        set(createTime).equalTo(record::createTime)
        set(updateTime).equalTo(record::updateTime)
        where(id, isEqualTo(record::id))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(nickname).equalToWhenPresent(record::nickname)
        set(headImg).equalToWhenPresent(record::headImg)
        set(username).equalToWhenPresent(record::username)
        set(phone).equalToWhenPresent(record::phone)
        set(password).equalToWhenPresent(record::password)
        set(status).equalToWhenPresent(record::status)
        set(createTime).equalToWhenPresent(record::createTime)
        set(updateTime).equalToWhenPresent(record::updateTime)
        where(id, isEqualTo(record::id))
    }