-- RedisScripts.USER_INFO_BY_TOKEN
-- key1 ${token}
-- key2 loginToken
-- key3 userInfo
local user_id=redis.call('hget',KEYS[2],KEYS[1]); if user_id then return redis.call('hget',KEYS[3],user_id) else return nil end