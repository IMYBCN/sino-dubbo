package com.sino.data.redis.dao;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2015/5/22.
 */
public class RedisStringDAO {
    private RedisTemplate redisTemplate;
    public static Logger redisLogger;

    static {
        redisLogger = Logger.getLogger(RedisStringDAO.class.getName());
    }

    public RedisStringDAO(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static RedisStringDAO init(RedisTemplate redisTemplate) {
        return new RedisStringDAO(redisTemplate);
    }


    /**
     * 如果值为数字，值增加delta
     *
     * @param key
     * @param delta
     * @return 增加后的值
     */
    public long set(final String key, final Long delta) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 如果值为数字，值增加delta
     *
     * @param key
     * @param delta
     * @return 增加后的值
     */
    public double set(final String key, final double delta) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 一次加入或替换多个键值对
     *
     * @param map
     */
    public void setMulti(final Map map) {
        redisLogger.debug("");
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 一次设置多个键值对（不存在的时候）
     *
     * @param map
     * @return 是否加入了
     */
    public boolean setMultiIfAbsent(final Map map) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().multiSetIfAbsent(map);
    }

    /**
     * 加入或替换一个键值对
     *
     * @param key
     * @param value
     */
    public void set(final String key, final String value) {
        redisLogger.debug("");
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 替换指定范围的字符串
     *
     * @param key
     * @param value
     * @param offSet
     */
    public void set(final String key, final Object value, final long offSet) {
        redisLogger.debug("");
        redisTemplate.opsForValue().set(key, value, offSet);
    }


    /**
     * 加入或替换一个键值对并设置key的生存时间为timeout,
     *
     * @param key
     * @param value
     * @param timeout 生存时间
     * @param unit    时间单位 如TimeUnit.MINUTES
     */
    public void set(final String key, final Object value, final long timeout, final TimeUnit unit) {
        redisLogger.debug("");
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 加入一个键值对(如果不存在)
     *
     * @param key
     * @param value
     * @return 是否加入成功
     */
    public boolean setIfAbsent(final String key, final String value) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 获取原来的值，并将新值替换进去
     *
     * @param key
     * @param newValue
     * @return 原来的值
     */
    public Object set(final String key, final Object newValue) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().getAndSet(key, newValue);
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
     * @param key
     * @param value
     * @return 追加后的字符串长度
     */
    public int append(final String key, final String value) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().append(key, value);
    }

    /**
     * 返回指定范围内的值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public String get(final String key, final long start, final long end) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().get(key, start, end);
    }

    public Object get(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 一次获取多个
     *
     * @param keys
     * @return
     */

    public List getMulti(final Set keys) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 字符串长度
     *
     * @param key
     * @return
     */
    public Long length(String key) {
        return redisTemplate.opsForValue().size(key);
    }

}
