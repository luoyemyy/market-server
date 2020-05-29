package com.github.luoyemyy.redis.service

import com.github.luoyemyy.redis.constants.RedisKey
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RedisResourceService : RedisBaseService() {

    @Autowired
    protected lateinit var redisUserService: RedisUserService

    /**
     * 校验用户是否有指定角色
     */
    fun hasRoleByUser(userId: Long, roleId: Long): Boolean {
        return redisUserService.getUserRole(userId).contains(roleId)
    }

    /**
     * 校验用户是否有指定角色和权限
     */
    fun hasResourceByUser(userId: Long, roleId: Long, resourceId: Long): Boolean {
        return hasRoleByUser(userId, roleId) && hasResourceByRole(roleId, resourceId)
    }

    /**
     * 校验角色是否有指定权限
     */
    fun hasResourceByRole(roleId: Long, resourceId: Long): Boolean {
        return hash().hasKey(RedisKey.role(roleId), resourceId.toString())
    }

    /**
     * 缓存角色对应的权限
     */
    fun cacheRoleResource(roleId: Long, resourceIds: List<Long>) {
        resourceIds.associateBy({ it.toString() }, { "1" }).apply {
            hash().putAll(RedisKey.role(roleId), this)
        }
    }
}