package com.sino.data.redis.dao;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2015/5/22.
 */
public class RedisListDAO {
    private RedisTemplate redisTemplate;
    public static Logger redisLogger;

    static {
        redisLogger = Logger.getLogger(RedisListDAO.class.getName());
    }

    public RedisListDAO(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static RedisListDAO init(RedisTemplate redisTemplate) {
        return new RedisListDAO(redisTemplate);
    }

    /**
     * 获取指定位置的值
     *
     * @param key
     * @param index
     * @return
     */
    public Object get(final String key, final long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 更改指定位置的值
     *
     * @param key
     * @param index
     * @param value
     */
    public void set(final String key, final long index, final String value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 检索然后获取指定范围内的元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> get(final String key, final int start, final int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 压栈
     *
     * @param key
     * @param value
     * @return
     */
    public Long push(final String key, final String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 出栈
     *
     * @param key
     * @return
     */
    public Object pop(final String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 入队
     *
     * @param key
     * @param value
     * @return
     */
    public Long offer(final String key, final String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 出队
     *
     * @param key
     * @return
     */
    public Object poll(final String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 栈/队长
     *
     * @param key
     * @return
     */
    public Long length(final String key) {
        return redisTemplate.opsForList().size(key);
    }


    /**
     * 删除列表中前count个值为value的元素
     *
     * @param key
     * @param count count>0 从左往右删除，count<0 从右往左删除，count=0 全部删除
     * @param value
     * @return 实际删除的个数
     */
    public long delete(final String key, final long count, final String value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    public void delete(final String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除指定key
     *
     * @param keys
     */
    public void delete(final Set keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 截取指定范围内的元素
     *
     * @param key
     * @param start
     * @param end
     */
    public void trim(final String key, final long start, final int end) {
        redisTemplate.opsForList().trim(key, start, end);
    }

}
