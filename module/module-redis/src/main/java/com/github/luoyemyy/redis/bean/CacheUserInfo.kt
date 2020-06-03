package com.github.luoyemyy.redis.bean

class CacheUserInfo(
        var userId: Long = 0,
        var nickname: String? = null,
        var headImg: String? = null,
        var username: String? = null,
        var phone: String? = null,
        var password: String? = null,
        var token: String? = null,
        var tokenExpire: Long = 0,
        var managerInfo: CacheManagerInfo? = null

)