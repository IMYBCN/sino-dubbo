package com.sino.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2015/5/22.
 */
public class DateUtil {
    /**
     * 格式化日期 将字符串日期格式为指定格式的字符串
     *
     * @param source 22/2/2015
     * @param format yyyy-MM-dd
     * @return 字符串日期
     */
    public static String formatToString(String source, String format) {
        if (source == null || "".equals(source)) return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.format(source);
    }

    /**
     * 格式化日期 将日期转换为指定格式的字符串
     *
     * @param source new date()
     * @param format yyyy-MM-dd
     * @return
     */
    public static String formatToString(Date source, String format) {
        if (source == null || "".equals(source)) return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.format(source);
    }

    /**
     * 格式化日期 将毫秒值转换为指定格式的字符串
     *
     * @param source 1432263687070L
     * @param format yyyy-MM-dd
     * @return 字符串日期
     */
    public static String formatToString(Long source, String format) {
        if (source == null || "".equals(source)) return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.format(new Date(source));
    }


    /**
     * 格式化日期 将指定格式的字符串转换为日期
     *
     * @param source 22/2/2015
     * @param format yyyy-MM-dd
     * @return 日期
     */
    public static Date formatToDate(String source, String format) {
        if (source == null || "".equals(source)) return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        Date date = null;
        try {
            date = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化日期 将日历转换为日期
     *
     * @param source 2015-05-22 11:01:27
     * @return 日期
     */
    public static Date formatToDate(Calendar source) {
        if (source == null || "".equals(source)) return null;

        return Calendar.getInstance().getTime();
    }

    /**
     * 格式化日期 将毫秒值转换为日期
     *
     * @param source 1432263687070L
     * @return 日期
     */
    public static Date formatToDate(Long source) {
        if (source == null || "".equals(source)) return null;
        return new Date(source);
    }

    /**
     * 格式化日期 将字符串转换为毫秒值
     *
     * @param source 2015-05-22 11:01:27
     * @return 毫秒值
     */
    public static Long formatToMillisecond(String source, String format) {
        if (source == null || "".equals(source)) return null;
        return formatToDate(source, format).getTime();
    }

    /**
     * 格式化日期 将日历转换为毫秒值
     *
     * @param source Calendar
     * @return 毫秒值
     */
    public static Long formatToMillisecond(Calendar source) {
        if (source == null || "".equals(source)) return null;
        return formatToDate(source).getTime();
    }

    /**
     * 格式化日期 将日期转换为日历
     *
     * @param source 2015-05-22 11:01:27
     * @return 日历
     */
    public static Calendar formatToCalendar(Date source) {
        if (source == null || "".equals(source)) return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        return calendar;
    }

    /**
     * 格式化日期 将毫秒值转换为日历
     *
     * @param source 2015-05-22 11:01:27
     * @return 日历
     */
    public static Calendar formatToCalendar(Long source) {
        if (source == null || "".equals(source)) return null;
        Date date = new Date(source);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 格式化日期 将字符串转换为日历
     *
     * @param source 字符串
     * @param format 字符串格式
     * @return
     */

    public static Calendar formatToCalendar(String source, String format) {
        if (source == null || "".equals(source)) return null;
        return formatToCalendar(formatToDate(source, format));
    }

    /**
     * 格式化日期 将日历转换为指定格式的字符串
     */
    public static String formatToString(Calendar source, String format) {
        if (source == null || "".equals(source)) return null;
        return formatToString(formatToDate(source), format);
    }

    /**
     * 获取年月日时分秒 数组中按照年月日时分秒放置
     *
     * @param source
     * @param separator 分隔符
     * @return
     */
    private static String[] getDetailFromString(String source, String separator) {
        if (source == null || "".equals(source)) return null;
        return source.split(separator);
    }

    /**
     * 获取年月日时分秒 返回值中按照年月日时分秒放置
     *
     * @param source "2015-06-10 11:40:03" "2015-06-10"
     * @return
     */
    public static String[] getDetailFromString(String source) {
        if (source == null || "".equals(source)) return null;
        source = source.replace(":", "-");
        source = source.replace(" ", "-");
        return getDetailFromString(source, "-");
    }

    /**
     * 获取年月日时分秒 返回值中按照年月日时分秒放置
     *
     * @param source
     * @return
     */
    public static String[] getDetailFromDate(Date source) {
        if (source == null || "".equals(source)) return null;
        return getDetailFromString(formatToString(source, "yyyy-MM-dd-HH-mm-ss"), "-");
    }

    /**
     * 获取年月日时分秒 返回值中按照年月日时分秒放置
     *
     * @param source
     * @return
     */
    public static String[] getDetailFromCalendar(Calendar source) {
        if (source == null || "".equals(source)) return null;
        return getDetailFromString(formatToString(source, "yyyy-MM-dd-HH-mm-ss"), "-");
    }

    public static void main(String[] args) {
        System.out.println(formatToMillisecond("2013-12-31", "yyyy-MM-dd"));
        System.out.println(formatToString(1435939200000L,"yyyy-MM-dd-HH-mm-ss"));
        //String[] a = getDetailFromDate(new Date());
        String[] a = getDetailFromString("2015-06-10 11:40:03");
        for (String s : a)
            System.out.println(s);
    }
}
