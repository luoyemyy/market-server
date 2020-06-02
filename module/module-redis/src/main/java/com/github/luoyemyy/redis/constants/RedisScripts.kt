package com.github.luoyemyy.redis.constants

object RedisScripts {

    /**
     * sha 5237ce9c0685147160055c03d3b20871b7953bda
     */
    const val CAS = "local key=KEYS[1]; local except=ARGV[1]; local update=ARGV[2]; local value=redis.call('get',key); if not value or value==except then redis.call('set',key,update); return update else return nil end"

    /**
     * key1 token
     * key2 token hash 的 key
     * key3 userInfo hash 的 key
     */
    const val USER_INFO_BY_TOKEN = "local user_id=redis.call('hget',KEYS[2],KEYS[1]); if user_id then return redis.call('hget',KEYS[3],user_id) else return nil end"

}