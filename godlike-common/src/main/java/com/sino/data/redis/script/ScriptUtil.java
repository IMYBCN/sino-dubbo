package com.sino.data.redis.script;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.List;


/**
 * Created by admin on 2015/5/28.
 */

public class ScriptUtil {
    private RedisTemplate redisTemplate;
    public static DefaultRedisScript script = new DefaultRedisScript();
    public static Logger redisLogger;

    static {
        redisLogger = Logger.getLogger(ScriptUtil.class.getName());
    }

    private ScriptUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * @param redisTemplate redisTemplate
     * @param filePath      脚本的路径
     * @param resultType    期望的返回值类型
     * @return
     */
    public static ScriptUtil init(RedisTemplate redisTemplate, String filePath, Class resultType) {
        ClassPathResource cp = new ClassPathResource(filePath);
        script.setScriptSource(new ResourceScriptSource(cp));
        script.setResultType(resultType);
        return new ScriptUtil(redisTemplate);
    }

    /**
     * 执行脚本 注意在执行的过程中spring-data-redis对keys args都进行了序列化。如果不需要序列化请使用原始的jedis提供的方法
     *
     * @param keys
     * @param args
     * @return
     */
    public Object execute(List<String> keys, Object... args) {
        return redisTemplate.execute(script, keys, args);
    }

    public static String makeSearchKey(final String tableName, final String fieldName, final String fieldValue) {
        return tableName + ":" + fieldName + ":" + fieldValue;
    }

}
