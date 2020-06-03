package com.github.luoyemyy.redis.constants

internal object RedisKey {

    //*****************************************************
    //*********************** hash ************************
    //*****************************************************
    const val LOGIN_TOKEN = "loginToken"        // hash key:loginToken              field:${token}      value:${userId}
    const val USER_INFO = "userInfo"            // hash key:userInfo                field:${userId}     value:${userInfo}
    const val ROLE_INFO = "role_info"           // hash key:role_info               field:${roleId}     value:${roleInfo}
    const val RESOURCE_INFO = "resource_info"   // hash key:resource_info           field:${resourceId} value:${resourceInfo}

    fun roleResource(roleId: Long): String {    // hash key:roleResource_${roleId}  field:${resourceId} value:0
        return "roleResource_${roleId}"
    }

    //*****************************************************
    //*********************** value ***********************
    //*****************************************************

}