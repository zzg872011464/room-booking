package com.example.roombooking.common.util.date;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    // /英文forward slash，缩写fs；\英文back slash，缩写bs
    public static final char PAD_NUMBER_CHAR = '0';
    public static final String CENTER_LINE = "-";
    public static final String YEAR_STRING = "年";
    public static final String MONTH_STRING = "月";
    public static final String DATE_STRING = "日";
    public static final String DATE_FORMAT_YYYY = "yyyy";
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";
    public static final String DATE_FORMAT_YYYY_WW = "yyyy-ww";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YYYY_WW_E = "yyyy-ww-e";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_MMDD = "MMdd";
    public static final String DATE_FOEMAT_FILE_DEFAULT = "yyyy-MM-dd_HH-mm-ss";
    public static final String DATE_FORMAT_DB_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_YEAR_MONTH = "yyyy" + YEAR_STRING + "MM" + MONTH_STRING;
    public static final String DATE_FORMAT_YEAR_MONTH_DATE = "yyyy" + YEAR_STRING + "MM" + MONTH_STRING + "dd" + DATE_STRING;
    public static final String DATE_FORMAT_MM_DD = "MM-dd";
    public static final String DATE_FORMAT_MM_DD_CN = "MM月dd日";
    public static final String DATE_FORMAT_YYYYMMDD_HHMMSS = "yyyyMMdd_HHmmss";
    public static final String DATE_FORMAT_YYYY_FS_MM = "yyyy/MM";
    public static final String DATE_FORMAT_HH_MM_SS = "HH:mm:ss";
    public static final String DATE_FORMAT_HH_MM = "HHmm";
    public static final String TIME_MIN_STR = "00:00:00";
    public static final String TIME_MAX_STR = "23:59:59";

    // 获取当前Date型日期
    public static Date getNowDate() {
        return new Date();
    }

    // 获取服务器启动时间
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    // date转字符串
    public static String parseDateToStr(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 计算时间差
     * @param endDate 结束时间
     * @param startDate 开始时间
     * @return 时间差（天/小时/分钟）
     */
    public static String timeDistance(Date endDate, Date startDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;

        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;

        return day + "天" + hour + "小时" + min + "分钟";
    }
}
