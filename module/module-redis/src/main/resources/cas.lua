-- RedisScripts.CAS
local key=KEYS[1];
local except=ARGV[1];
local update=ARGV[2];
local value=redis.call('get',key);
if not value or value==except then
    redis.call('set',key,update);
    return update
else
    return nil
end