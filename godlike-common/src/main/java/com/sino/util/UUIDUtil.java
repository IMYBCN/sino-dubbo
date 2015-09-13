package com.sino.util;

import java.util.UUID;

/**
 * Created by pierce-deng on 2015/8/18.
 */
public class UUIDUtil {
    public UUIDUtil() {
    }

    /**
     * 获取一个uuid
     *
     * @return uuid(去除下划线, 字母转换为大写)
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
        return uuid.toUpperCase();
    }

    /**
     * 获取number个uuid
     *
     * @param number 需要的uuid数量
     * @return
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] uuids = new String[number];
        for (int i = 0; i < number; i++) {
            uuids[i] = getUUID();
        }
        return uuids;
    }

}
