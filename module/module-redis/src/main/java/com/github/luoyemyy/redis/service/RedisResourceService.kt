package com.github.luoyemyy.redis.service

import com.github.luoyemyy.redis.bean.CacheRoleRights
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
    fun hasRightsByUser(userId: Long, roleId: Long, rightsId: Long): Boolean {
        return hasRoleByUser(userId, roleId) && hasRightsByRole(roleId, rightsId)
    }

    /**
     * 校验角色是否有指定权限
     */
    fun hasRightsByRole(roleId: Long, rightsId: Long): Boolean {
        return hash().hasKey(RedisKey.role(roleId), rightsId.toString())
    }

    /**
     * 缓存角色对应的权限
     */
    fun cacheRoleRights(roleRights: List<CacheRoleRights>) {
        roleRights.forEach { rr ->
            rr.rights?.associateBy({ it.toString() }, { "1" })?.apply {
                hash().putAll(RedisKey.role(rr.roleId), this)
            }
        }
    }
}