package com.github.luoyemyy.common.util

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import java.text.SimpleDateFormat

inline fun <reified T> String?.toList(): List<T>? {
    val type = JsonUtil.objectMapper.typeFactory.constructCollectionType(ArrayList::class.java, T::class.java)
    return if (this == null) null else JsonUtil.objectMapper.readValue(this, type)
}

inline fun <reified T> String?.toObject(): T? {
    val type = JsonUtil.objectMapper.typeFactory.constructType(T::class.java)
    return if (this == null) null else JsonUtil.objectMapper.readValue(this, type)
}

fun Any?.toJsonString(): String? {
    return if (this == null) null else JsonUtil.objectMapper.writeValueAsString(this)
}

object JsonUtil {
    val objectMapper = ObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        dateFormat = SimpleDateFormat(DateUtil.FORMAT_YMDHMS)
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
    }
}

