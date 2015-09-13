package com.sino.io;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * properties文件工具
 */
public class PropertiesUtil {
    /**
     * 读取properties和xml文件
     *
     * @param filePath 文件名
     * @return 文件的键值对map
     */
    public static Map<String, String> read(String filePath) {
        Map<String, String> map = new HashMap<>();
        ClassPathResource cp = new ClassPathResource(filePath);
        Properties properties = new Properties();
        try {
            properties.load(cp.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("load " + filePath + " error!");
        }
        Enumeration en = properties.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String value = properties.getProperty(key);
            map.put(key, value);
        }
        return map;
    }

}
