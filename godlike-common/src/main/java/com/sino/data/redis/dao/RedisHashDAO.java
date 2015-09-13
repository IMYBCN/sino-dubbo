package com.sino.data.redis.dao;

/**
 * Created by admin on 2015/5/22.
 */

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 适合用来存放对象 key为对象名构建的key，field为属性名，value为属性值
 */
public class RedisHashDAO {
    private RedisTemplate redisTemplate;
    public static Logger redisLogger;

    static {
        redisLogger = Logger.getLogger(RedisHashDAO.class.getName());
    }

    public RedisHashDAO(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static RedisHashDAO init(RedisTemplate redisTemplate) {
        return new RedisHashDAO(redisTemplate);
    }


    /**
     * 加入或替换一个
     *
     * @param key
     * @param field
     * @param value
     */
    public void set(final String key, final Object field, final Object value) {
        redisLogger.debug("");
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 批量加入或替换
     *
     * @param key
     * @param map
     */
    public void set(final String key, final Map map) {
        redisLogger.debug("");
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 如果不存在则加入
     *
     * @param key
     * @param field
     * @param value
     * @return 是否成功加入
     */
    public boolean setIfAbsent(final String key, final Object field, final Object value) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().putIfAbsent(key, field, value);
    }

    /**
     * 如果为数字则将指定filed的值增加delta
     *
     * @param key
     * @param field
     * @param delta
     * @return 增加后的值
     */
    public double set(final String key, final Object field, final double delta) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().increment(key, field, delta);
    }

    /**
     * 如果为数字则将指定filed的值增加delta
     *
     * @param key
     * @param field
     * @param delta
     * @return 增加后的值
     */
    public double set(final String key, final Object field, final long delta) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().increment(key, field, delta);
    }

    /**
     * 批量删除指定field
     *
     * @param key
     * @param fields
     */
    public void delete(final String key, final Object... fields) {
        redisLogger.debug("");
        redisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    public void delete(final String key) {
        redisLogger.debug("");
        redisTemplate.delete(key);
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
     * 获取指定key的全部field
     *
     * @param key
     * @return
     */
    public Set getFields(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * 获取指定field的value
     *
     * @param key
     * @param field
     * @return
     */
    public Object get(final String key, final Object field) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 获取指定key的实体（相等于获取对象的所有属性和对应的值）
     *
     * @param key
     * @return
     */
    public Map get(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 批量获取指定field的value
     *
     * @param key
     * @param fields
     * @return
     */
    public List getMulti(final String key, Set fields) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().multiGet(key, fields);
    }

    /**
     * 获取指定key的所有value
     *
     * @param key
     * @return
     */
    public List getValues(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().values(key);
    }

    /**
     * 判断一个filed是否存在
     *
     * @param key
     * @param field
     * @return
     */
    public boolean exists(final String key, final Object field) {
        redisLogger.debug("");
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * 获取指定key的map的长度
     *
     * @param key
     * @return
     */

    public Long length(String key) {
        return redisTemplate.opsForHash().size(key);
    }


}
