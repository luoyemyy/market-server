package com.github.luoyemyy.redis.service

import com.github.luoyemyy.common.util.toJsonString
import com.github.luoyemyy.redis.bean.CacheResource
import com.github.luoyemyy.redis.bean.CacheRoleResource
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

    fun cacheRoleResource(roleResources: CacheRoleResource) {
        val value = toByte(0) ?: return
        val resources = roleResources.resources ?: return
        if (resources.isNotEmpty()) {
            val roleId = toByte(RedisKey.roleResource(roleResources.roleId)) ?: return
            redisTemplate.executePipelined { c ->
                resources.forEach { r ->
                    toByte(r)?.also { resourceId ->
                        c.hashCommands().hSet(roleId, resourceId, value)
                    }
                }
            }
        }
    }

    fun cacheResource(resources: List<CacheResource>?) {
        if (!resources.isNullOrEmpty()) {
            resources.associateBy({ it.resourceId.toString() }, { it.toJsonString() }).apply {
                hash().putAll(RedisKey.RESOURCE_INFO, this)
            }
        }
    }
}