package com.suyan.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 判断当前日期是星期几
     */
    public static String dayForWeek(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        switch (dayForWeek) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            case 7:
                return "星期日";
        }

        return "";
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (format == null || format.equals("")) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 时间添加
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static Date addTime(Date date, int field, int amount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 计算时间
     *
     * @param nowDate
     * @param date
     * @return
     */
    public static String calcTime(Date nowDate, Date date) {
        String time = "";
        if (nowDate == null || date == null) {
            return time;
        }
        long diff = (nowDate.getTime() - date.getTime()) / (1000 * 60);
        if (diff <= 1) {
            time = "1分钟前";
        } else if (diff <= 60) {
            time = diff + "分钟前";
        } else if (diff < 24 * 60) {
            time = diff / 60 + "小时前";
        } else if (diff <= 7 * 24 * 60) {
            time = diff / (24 * 60) + "天前";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            time = sdf.format(date);
        }
        return time;
    }

}
