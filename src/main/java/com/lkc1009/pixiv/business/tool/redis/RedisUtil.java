package com.lkc1009.pixiv.business.tool.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    private final RedisTemplate<String, Object> redisTemplate;

    RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean expire(String key, Long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    public Long getTime(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public Boolean persist(String key) {
        return redisTemplate.boundValueOps(key).persist();
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, Long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    public void batchSet(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSet(keyAndValue);
    }

    public void batchSetIfAbsent(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSetIfAbsent(keyAndValue);
    }

    public Long increment(String key, Long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    public Double increment(String key, Double number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    public void sSet(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    public Set<Object> members(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    public void randomMembers(String key, Long count) {
        redisTemplate.opsForSet().randomMembers(key, count);
    }

    public Object randomMember(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    public Object pop(String key) {
        return redisTemplate.opsForSet().pop("setValue");
    }

    public Long size(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    public Boolean sHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    public Boolean isMember(String key, Object obj) {
        return redisTemplate.opsForSet().isMember(key, obj);
    }

    public Boolean move(String key, String value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    public void remove(String key, Object... values) {
        redisTemplate.opsForSet().remove(key, values);
    }

    public Set<Object> difference(String key, String destKey) {
        return redisTemplate.opsForSet().difference(key, destKey);
    }

    public void add(String key, Map<String, String> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Map<Object, Object> getHashEntries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public Boolean hashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public String getMapString(String key, String key2) {
        return Objects.requireNonNull(redisTemplate.opsForHash().get("map1", "key1")).toString();
    }

    public Integer getMapInt(String key, String key2) {
        return (Integer) redisTemplate.opsForHash().get("map1", "key1");
    }

    public String popValue(String key) {
        return Objects.requireNonNull(redisTemplate.opsForSet().pop(key)).toString();
    }

    public Long delete(String key, String... hashKeys) {
        return redisTemplate.opsForHash().delete(key, (Object) hashKeys);
    }

    public Long increment(String key, String hashKey, Long number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    public Double increment(String key, String hashKey, Double number) {
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    public Set<Object> hashKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    public Long hashSize(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public Object index(String key, Long index) {
        return redisTemplate.opsForList().index("list", 1);
    }

    public List<Object> range(String key, Long start, Long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    public void leftPush(String key, String pivot, String value) {
        redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    public void leftPushAll(String key, String... values) {
        redisTemplate.opsForList().leftPushAll(key, values);
    }

    public void leftPushAll(String key, String value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    public void rightPushAll(String key, String... values) {
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    public void rightPushIfPresent(String key, Object value) {
        redisTemplate.opsForList().rightPushIfPresent(key, value);
    }

    public Long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public void leftPop(String key) {
        redisTemplate.opsForList().leftPop(key);
    }

    public void leftPop(String key, Long timeout, TimeUnit unit) {
        redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    public void rightPop(String key) {
        redisTemplate.opsForList().rightPop(key);
    }

    public void rightPop(String key, Long timeout, TimeUnit unit) {
        redisTemplate.opsForList().rightPop(key, timeout, unit);
    }
}
