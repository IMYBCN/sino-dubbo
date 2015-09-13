package com.sino.io.examples.propertiesUtil;

import com.sino.io.PropertiesUtil;

import java.util.Map;

/**
 * Created by admin on 2015/5/21.
 */
public class PropertiesUtilTest {
    public static void main(String[] args) {
        Map<String, String> map = PropertiesUtil.read("log4j.properties");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

    }
}
