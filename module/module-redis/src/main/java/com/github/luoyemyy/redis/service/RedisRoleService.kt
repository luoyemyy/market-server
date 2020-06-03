package com.github.luoyemyy.redis.service

import com.github.luoyemyy.redis.constants.RedisKey
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RedisRoleService : RedisBaseService() {

    @Autowired
    protected lateinit var redisUserService: RedisUserService

    /**
     * 校验角色是否有指定权限
     */
    fun hasResourceByRole(roleId: Long, resourceId: Long): Boolean {
        return hash().hasKey(RedisKey.roleResource(roleId), resourceId.toString())
    }

    /**
     * 缓存角色对应的权限
     */
//    fun cacheRoleResource(roleId: Long, resourceIds: List<Long>) {
//        resourceIds.associateBy({ it.toString() }, { "1" }).apply {
//            hash().putAll(RedisKey.role(roleId), this)
//        }
//    }
}