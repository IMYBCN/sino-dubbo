package com.sino.data.redis.dao;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2015/5/22.
 */
public class RedisSetDAO {
    private RedisTemplate redisTemplate;
    public static Logger redisLogger;

    static {
        redisLogger = Logger.getLogger(RedisSetDAO.class.getName());
    }

    public RedisSetDAO(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static RedisSetDAO init(RedisTemplate redisTemplate) {
        return new RedisSetDAO(redisTemplate);
    }

    /**
     * 批量加入或替换
     *
     * @param key
     * @param values
     * @return 成功加入的个数
     */
    public long set(final String key, Object... values) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 求多集合并集并将并集结果放入destKey中
     *
     * @param key1
     * @param keys
     * @param destKey
     * @return 成功放入destKey中的元素个数
     */
    public long setUnion(final String key1, final Set keys, final String destKey) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().unionAndStore(key1, keys, destKey);
    }

    public long setUnion(final String key1, final String key2, final String destKey) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().unionAndStore(key1, key2, destKey);
    }

    /**
     * 求多集合交集并将结果放在destKey中
     *
     * @param key1
     * @param keys
     * @param destKey
     * @return 交集元素个数
     */
    public long setSame(final String key1, final Set keys, final String destKey) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().intersectAndStore(key1, keys, destKey);
    }

    /**
     * 求集合交集并将结果放在destKey中
     *
     * @param key1
     * @param key2
     * @param destKey
     * @return 交集元素个数
     */
    public long setSame(final String key1, final String key2, final String destKey) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().intersectAndStore(key1, key2, destKey);
    }

    /**
     * 求差集并存放到destKey中
     *
     * @param key1
     * @param key2
     * @param destKey 存放差集的key
     * @return 返回差集元素个数
     */
    public long setDifference(final String key1, final String key2, final String destKey) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().differenceAndStore(key1, key2, destKey);
    }

    /**
     * 多集合求差集并存放到destKey中
     *
     * @param key1
     * @param keys
     * @param destKey 存放差集的key
     * @return 返回差集元素个数
     */
    public long setDifference(final String key1, final Set keys, final String destKey) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().differenceAndStore(key1, keys, destKey);
    }


    /**
     * 获key集合的所有元素
     *
     * @param key
     * @return
     */
    public Set get(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 随机获得count个不重复的元素
     *
     * @param key
     * @param count
     * @return
     */
    public Set getDistinctRandomMenbers(final String key, final long count) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().distinctRandomMembers(key, count);
    }

    /**
     * 随机获得一个元素
     *
     * @param key
     * @return
     */
    public Object getRandomMenber(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * 随机获得多个元素
     *
     * @param key
     * @param count
     * @return
     */
    public List getRandomMenbers(final String key, final long count) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().randomMembers(key, count);
    }


    /**
     * 多集合差集key1-key2-key3.....
     *
     * @param key1
     * @param keys
     * @return
     */
    public Set getDifference(final String key1, final Set keys) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().difference(key1, keys);
    }

    /**
     * 差集
     *
     * @param key1
     * @param key2
     * @return
     */
    public Set getDifference(final String key1, final String key2) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().difference(key1, key2);
    }


    /**
     * 多集合并集
     *
     * @param key1
     * @param keys
     * @return
     */
    public Set getUnion(final String key1, final Set keys) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().union(key1, keys);
    }


    public Set getUnion(final String key1, final String key2) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().union(key1, key2);
    }

    /**
     * 交集
     *
     * @param key1
     * @param key2
     * @return 交集
     */
    public Set getSame(final String key1, final String key2) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().intersect(key1, key2);
    }

    /**
     * 多集合交集
     *
     * @param key1
     * @param keys
     * @return 交集
     */
    public Set getSame(final String key1, final Set keys) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().intersect(key1, keys);
    }


    /**
     * 某个元素是否属于指定的key
     *
     * @param key
     * @param object
     * @return 是否属于指定key集合
     */
    public boolean isMember(final String key, final Object object) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().isMember(key, object);
    }


    /**
     * 获取key集合的元素个数
     *
     * @param key
     * @return
     */
    public long length(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 删除key集合
     *
     * @param key
     */
    public void delete(final String key) {
        redisLogger.debug("");
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key 集合中的value
     *
     * @param key
     * @param values
     * @return 成功删除的元素个数
     */
    public long delete(final String key, final Object... values) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * 批量删除指定key
     *
     * @param keys
     */
    public void delete(final Set keys) {
        redisLogger.debug("");
        redisTemplate.delete(keys);
    }

    /**
     * 随机删除一个元素
     *
     * @param key
     * @return 删除的元素
     */
    public Object deleteRandom(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 将key集合中value元素移动到destKey集合中
     *
     * @param key
     * @return 是否成功移动
     */
    public boolean move(final String key, final Object value, final String destKey) {
        redisLogger.debug("");
        return redisTemplate.opsForSet().move(key, value, destKey);
    }


}
