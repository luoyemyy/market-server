package com.github.luoyemyy.redis.bean

class CacheUserInfo(
        var userId: Long = 0,
        var name: String? = null,
        var role: List<Long>? = null,
        var token: String? = null
) {

    companion object {
        const val USER_ID = "userId"
        const val NAME = "name"
        const val ROLE = "role"
        const val TOKEN = "token"

        val ALL_KEYS = listOf(USER_ID, NAME, ROLE, TOKEN)

        fun mapOf(values: List<String>?): CacheUserInfo? {
            return values?.let {
                if (ALL_KEYS.size == it.size) {
                    CacheUserInfo(
                            userId = mapUserId(it[0]),
                            name = it[1],
                            role = mapRole(it[2]),
                            token = it[3]
                    )
                } else {
                    null
                }
            }
        }

        fun mapUserId(userId: String?): Long {
            return userId?.toLongOrNull() ?: 0
        }

        fun mapRole(role: String?): List<Long> {
            return role?.split(",")?.mapNotNull { it.toLongOrNull() } ?: listOf()
        }
    }
}