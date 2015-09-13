package com.sino.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by admin on 2015/5/22.
 */
public class JsonUtil {
    private ObjectMapper objectMapper;

    /**
     * java对象转换为json字符串
     *
     * @param object java对象
     * @return json字符串
     */
    public String fromObjectToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解析对象错误");
        }
    }

}
