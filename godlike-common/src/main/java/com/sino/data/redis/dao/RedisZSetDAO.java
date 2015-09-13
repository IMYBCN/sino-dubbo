package com.sino.data.redis.dao;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * Created by admin on 2015/5/22.
 */
public class RedisZSetDAO {
    private RedisTemplate redisTemplate;
    public static Logger redisLogger;

    static {
        redisLogger = Logger.getLogger(RedisZSetDAO.class.getName());
    }

    public RedisZSetDAO(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public static RedisZSetDAO init(RedisTemplate redisTemplate) {
        return new RedisZSetDAO(redisTemplate);
    }

    public Object set(final String key, final Object value, final double score) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 批量加入或替换
     *
     * @param key
     * @param set
     * @return 成功加入或者替换的元素个数
     */
    public long set(final String key, final Set set) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().add(key, set);
    }

    /**
     * 获得指定分数范围内的元素个数
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public long count(final String key, final double min, final double max) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    /**
     * 增加指定元素的分数
     *
     * @param key
     * @param value
     * @param delta
     * @return 增加后的分数
     */
    public double incrementScore(final String key, final Object value, final double delta) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    /**
     * 获得指定分数范围内的元素
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Object rangeByscore(final String key, final double min, final double max) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 在获得指定分数范围内的元素的基础上获得从offset开始的count个元素
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Object rangeByscore(final String key, final double min, final double max, final long offset, final long count) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
    }

    /**
     * 获得指定分数范围内的元素和对应的分数
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set rangeByscoreWithScores(final String key, final double min, final double max) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    /**
     * 在获得指定分数范围内的元素的基础上获得从offset开始的count个元素和对应的分数
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set rangeByscoreWithScores(final String key, final double min, final double max, final long offset, final long count) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max, offset, count);
    }

    /**
     * 获得索引范围为start到end的元素和对应的分数
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set rangeWithScores(final String key, final long start, final long end) {
        redisLogger.debug("");
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }


    public Object get(final String key) {
        redisLogger.debug("");
        return redisTemplate.opsForValue().get(key);
    }
}
