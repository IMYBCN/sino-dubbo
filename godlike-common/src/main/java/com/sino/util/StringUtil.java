package com.sino.util;

/**
 * Created by admin on 2015/5/22.
 */
public class StringUtil {
    /**
     * 判断字符串是否为空（空字符不为空）
     *
     * @param str
     * @return false不为空 true为空
     */
    public static boolean isNotNull(String str) {
        return null != str && !"".equals(str);
    }

    /**
     * 判断字符串是否为空（空字符也为空）
     *
     * @param str
     * @return false不为空 true为空
     */
    public static boolean isNotBlank(String str) {
        return isNotNull(str) && isNotNull(str.trim());
    }

    /**
     * 判断字符串是否为未知
     *
     * @param str
     * @return false不是未知的 true未知的
     */
    public static boolean isNotUnknown(String str) {
        return "unknown".equalsIgnoreCase(str.trim());
    }

    /**
     * 首字母大写
     *
     * @param str
     * @return 首字母大写的字符串
     */
    public static String firstToUpper(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }

    /**
     * 首字母小写
     *
     * @param str
     * @return 首字母小写的字符串
     */
    public static String firstToLower(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
    }

    /**
     * 获得按指定字符分拆后的第一个字符串
     *
     * @param str
     * @param separator
     * @return
     */
    public static String getSplitedFirst(String str, String separator) {
        String[] array = str.split(separator);
        return array == null ? null : array[0];
    }

    /**
     * 获得按指定字符分拆后的最后一个字符串
     *
     * @param str
     * @param separator
     * @return
     */
    public static String getSplitedLast(String str, String separator) {
        String[] array = str.split(separator);
        return array == null ? null : array[array.length - 1];
    }

    /**
     * 将字符串转换为小写，并在被转换的字母前边或者后边加上一个指定字符
     *
     * @param str
     * @param separator 将被添加的字母，如果不进行添加设为""
     * @param isAhead   是否添加到被转换字母的前边，true是添加到前边，false添加到后边
     * @return
     */
    public static String toLower(String str, String separator, boolean isAhead) {
        if (str != null && !"".equals(str)) {
            String rs = "";
            char c[] = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (isAhead)
                    rs += (c[i] + "").matches("[A-Z]") ? (separator + c[i]).toLowerCase() : c[i];
                else
                    rs += (c[i] + "").matches("[A-Z]") ? (c[i] + separator).toLowerCase() : c[i];
            }
            return rs;
        }
        return str;
    }

}
