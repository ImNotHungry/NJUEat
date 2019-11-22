package com.nju.edu.njueat.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 */
public class DateUtil {
    private static final String NORMAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间转字符串
     * @param date 时间
     * @return 对应字符串
     */
    public static String dateToStr(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(NORMAL_PATTERN);
        return formatter.format(date);
    }

    /**
     * 字符串转时间
     * @param dateStr 字符串
     * @return 对应时间
     */
    public static LocalDateTime strToDate(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(NORMAL_PATTERN);
        return LocalDateTime.parse(dateStr, formatter);
    }
}
