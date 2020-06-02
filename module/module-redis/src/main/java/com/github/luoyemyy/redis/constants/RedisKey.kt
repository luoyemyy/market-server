package com.github.luoyemyy.redis.constants

object RedisKey {

    //*****************************************************
    //*********************** hash ************************
    //*****************************************************
    const val LOGIN_TOKEN = "loginToken"        // hash key:loginToken field:${token} value:${userId}
    const val USER_INFO = "userInfo"            // hash key:userInfo field:${userId} value:${userInfo}
    const val ROLE_RESOURCE = "roleResource_"   // hash key:roleResource field:${roleId} value:${userInfo}

    //*****************************************************
    //*********************** value ***********************
    //*****************************************************
    const val RESOURCE_INFO = "resource_info_"   // value key:resource_info_${resourceId}

}