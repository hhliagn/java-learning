package com.javalearning.demo.excel.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

public class DateUtils {

    public static final int DAY_SECOND = 60 * 60 * 24;

    public static final int SEVEN_DAY_SECOND = 7 * 60 * 60 * 24;

    public static LocalDate FUTURE_LOCAL_DATE;
    public static Date FUTURE_DATE;

    private static final DateTimeFormatter DATE_FORMAT_WITH_SLASH = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    // 格式成没连字符的ymd格式
    private static final DateTimeFormatter DATE_FORMAT_WITHOUT_HYPHEN = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static final ZoneId SYSTEM_ZONE = ZoneId.systemDefault();

    static {
        FUTURE_LOCAL_DATE = LocalDate.of(9999, 1, 1);
        FUTURE_DATE = toDate(FUTURE_LOCAL_DATE);
    }

    private static Pattern numPattern = Pattern.compile("\\d+");

    private static ZonedDateTime toZonedDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return toZonedDateTime(date).toLocalDateTime();
    }

    public static LocalDate toLocalDate(Date date) {
        return toZonedDateTime(date).toLocalDate();
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(Long timeMillis) {
        return timeMillis == null ? null : new Date(timeMillis);
    }

    public static Date toDate(Integer timeSecond) {
        return timeSecond == null ? null : new Date((long) timeSecond * 1000);
    }

    public static int getNowTimeSecond() {
        return (int) (System.currentTimeMillis() / 1000);
    }


    public static Date toDateWithoutMinuteAndSeconds(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }

    public static Date startOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        return calendar.getTime();
    }

    public static Date endOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date startOfDate(LocalDate localDate) {
        return DateUtils.toDate(localDate.atStartOfDay());
    }

    public static Date endOfDate(LocalDate localDate) {
        return DateUtils.toDate(localDate.atTime(LocalTime.MAX));
    }

    /**
     * @return 这个月第一天的开始时间
     */
    public static Date getFirstDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(firstDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStartOfToday() {
        LocalDate today = LocalDate.now();
        return Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date expiresInToDate(long expireIn, TemporalUnit temporalUnit) {
        return Date.from(Instant.now().plus(expireIn, temporalUnit));
    }

    public static Date parseDateMill(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 转换yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd格式的字符串为Date
     */
    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf;
        if (dateStr.contains("-")) {
            if (dateStr.length() > 10) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (numPattern.matcher(dateStr).matches()) {
            return new Date(Long.parseLong(dateStr));
        } else {
            throw new IllegalArgumentException("unknown datetime string: " + dateStr);
        }
    }

    /**
     * 转换yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd格式的字符串为Integer
     */
    public static Integer parseDateToInt(String dateStr) {
        try {
            Date date = parseDate(dateStr);
            Integer second = Math.toIntExact(date.getTime() / 1000L);
            if (second == null) {
                return 0;
            }
            return second;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 转换Integer为yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd格式的字符串
     */
    public static String parseIntToDate(Integer Time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format((long) Time * 1000L);
    }

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate parseLocalDate(String dateStr) {
        if (dateStr.contains("-")) {
            if (dateStr.length() > 10) {
                dateStr = dateStr.substring(0, 10);
            }
            try {
                return LocalDate.parse(dateStr, dateFormatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (numPattern.matcher(dateStr).matches()) {
            long millis = Long.parseLong(dateStr);
            return LocalDateTime.ofEpochSecond(millis / 1000, 0, ZoneOffset.UTC).toLocalDate();
        } else {
            throw new IllegalArgumentException("unknown localdate string: " + dateStr);
        }
    }

    public static long localDateToTimestamp(LocalDate date) {
        return date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }

    public static String formatToYmd(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String formatToYmdWithoutHyphen(Date date) {
        if (date == null) return "";
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    // 转换成无连字符的ymd格式
    public static String formatToYmdWithoutHyphen(LocalDate date) {
        if (date == null) return "";
        return DATE_FORMAT_WITHOUT_HYPHEN.format(date);
    }

    public static String formatToYmdhms(Date date) {
        if (date == null) return "";
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ymdhmsFormat.format(date);
    }

    public static String formatToYmdhms(Integer timestamp) {
        if (timestamp == null) return "";
        Date date = new Date(timestamp.longValue() * 1000);
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ymdhmsFormat.format(date);
    }

    public static String formatToYmdhmsWithoutSpace(Date date) {
        if (date == null) return "";
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return ymdhmsFormat.format(date);
    }

    public static Long toLong(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime();
    }

    public static Long toLong(LocalDate localDate) {
        if (localDate == null) return null;
        return toLong(toDate(localDate));
    }

    public static String formatDate(Temporal time) {
        if (time == null) {
            return "";
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateFormat.format(time);
    }

    public static String formatDateWithSlash(Temporal time) {
        return DATE_FORMAT_WITH_SLASH.format(time);
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static String formatDateTime(Date time) {
        if (time == null) {
            return "";
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(time);
    }

    public static String formatDateTime(LocalDateTime time) {
        if (time == null) {
            return "";
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return format.format(time);
    }

    public static String formatLocalDate(LocalDate date, String format) {
        if (format == null) {
            format = "/";
        }
        format = "yyyy".concat(format).concat("MM").concat(format).concat("dd");
        return new SimpleDateFormat(format).format(toDate(date));
    }

    public static Date dateMin(Date a, Date b) {
        return a.after(b) ? b : a;
    }


    public static int differentDays(Date startTime, Date entTime) {
        Calendar start = Calendar.getInstance();
        start.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(entTime);
        int day1 = start.get(Calendar.DAY_OF_YEAR);
        int day2 = end.get(Calendar.DAY_OF_YEAR);

        int year1 = start.get(Calendar.YEAR);
        int year2 = end.get(Calendar.YEAR);

        //同一年
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    //闰年
                    timeDistance += 366;
                } else {
                    //不是闰年
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else { //不同年
            return day2 - day1;
        }
    }

    public static String formatToHms(Date date) {
        if (date == null) return "";
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("HH:mm:ss");
        return ymdhmsFormat.format(date);
    }

    public static Date parseToTime(String timeStr) {
        if (StringUtils.isBlank(timeStr)) return null;
        SimpleDateFormat ymdhmsFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return ymdhmsFormat.parse(timeStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 将时间转换为时间戳
     *
     * @param sf
     * @param date
     * @return
     */
    public static long dateToStamp(SimpleDateFormat sf, String date) {
        try {
            if (date != null) {
                Date d = sf.parse(date);
                return d.getTime() / 1000;
            }
        } catch (ParseException e) {
            return 0;
        }
        return 0;
    }

    /**
     * 将时间戳转换为时间
     *
     * @param sf
     * @param stamp
     * @return
     */
    public static String stampToDate(SimpleDateFormat sf, Long stamp) {
        if (stamp == null || stamp == 0) return "";
        Date date = new Date(stamp * 1000);
        return NumberUtils.dropDot(sf.format(date));
    }

    /**
     * 计算指定日期的当月第一天，如2019-09-01 00:00:00
     *
     * @param timepoint
     * @return
     */
    public static Date getMonthStart(Date timepoint) {
        DateTime dt = new DateTime(timepoint);
        Date start = dt.dayOfMonth().withMinimumValue().toDate();
        return startOfDate(start);
    }

    /**
     * 计算指定日期的当月最后一天，如2019-09-30 23:59:59
     *
     * @param timepoint
     * @return
     */
    public static Date getMonthEnd(Date timepoint) {
        DateTime dt = new DateTime(timepoint);
        Date end = dt.dayOfMonth().withMaximumValue().toDate();
        return endOfDate(end);
    }

    public static Date getYearStart(int year) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.MONTH, Calendar.JANUARY);
        return getMonthStart(ca.getTime());
    }

    public static Date getYearEnd(int year) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.MONTH, Calendar.DECEMBER);
        return getMonthEnd(ca.getTime());
    }

    public static Date getMonthStart(int year, int month) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.MONTH, month - 1);
        return getMonthStart(ca.getTime());
    }

    public static Date getMonthEnd(int year, int month) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.MONTH, month - 1);
        return getMonthEnd(ca.getTime());
    }

    public static int getMonthStartSecond(int year, int month) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.MONTH, month - 1);
        return (int) (getMonthStart(ca.getTime()).getTime() / 1000);
    }

    public static int getMonthEndSecond(int year, int month) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, year);
        ca.set(Calendar.MONTH, month - 1);
        return (int) (getMonthEnd(ca.getTime()).getTime() / 1000);
    }

    public static Date getTomorrow(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        return date;
    }

    public static LocalDateTime plusDays(LocalDateTime time, long days) {
        if (time == null) {
            time = LocalDateTime.now();
        }
        return time.plusDays(days);
    }

    public static Date getToday() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getTodayEnd() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date getYesterday() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -1);//把日期往前一天.整数往后推,负数往前移动
        //这个时间就是日期往后推一天的结果
        return calendar.getTime();
    }

    public static Date getYesterdayEnd() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -1);//把日期往前一天.整数往后推,负数往前移动
        //这个时间就是日期往后推一天的结果
        return calendar.getTime();
    }

    public static Date getPreSevenday() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -6);//把日期往前一天.整数往后推,负数往前移动
        //这个时间就是日期往后推一天的结果
        return calendar.getTime();
    }

    public static Date getPreMonthday() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -29);//把日期往前一天.整数往后推,负数往前移动
        //这个时间就是日期往后推一天的结果
        return calendar.getTime();
    }

    public static long getStringToDate(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 日期按日加减计算
     *
     * @param timepoint
     * @param period
     * @return
     */
    public static Date addDatesByDay(Date timepoint, int period) {
        DateTime dt = new DateTime(timepoint);
        return dt.plusDays(period).toDate();
    }

    /**
     * 日期按月加减计算
     *
     * @param timepoint
     * @param period
     * @return
     */
    public static Date addDatesByMonth(Date timepoint, int period) {
        DateTime dt = new DateTime(timepoint);
        return dt.plusMonths(period).toDate();
    }

    /**
     * 计算指定日期的最大时间，如2015-08-01 23:59:59
     *
     * @param d
     * @return
     */
    public static Date buildMaxOfDate(Date d) {
        DateTime time = new DateTime(d);
        return time.millisOfDay().withMaximumValue().toDate();
    }

    /**
     * 计算指定日期的最小时间，如2015-08-01 00:00:00
     *
     * @param d
     * @return
     */
    public static Date buildMinOfDate(Date d) {
        DateTime time = new DateTime(d);
        return time.millisOfDay().withMinimumValue().toDate();
    }

    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static long[] getDistanceTimes(Date startTime, Date endTime) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long time1 = startTime.getTime();
        long time2 = endTime.getTime();
        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long[] times = {day, hour, min, sec};
        return times;
    }

    /**
     * 将字符串转成Date类型（用于转换微服务传过来的时间）
     *
     * @param dateString 时间字符串
     * @return java.util.Date
     **/
    public static Date convertToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return formatter.parse(dateString);
    }


    public static String numberDateFormat(Long timestamp, SimpleDateFormat sdf) {
        String date = null;
        if ((timestamp + "").length() == 13) {
            date = sdf.format(timestamp);
        } else {
            date = sdf.format(timestamp * 1000);
        }
        return date;
    }

    public static long getSecondTimestamp(LocalDateTime time) {
        if (time == null) {
            return 0L;
        }
        ZoneId systemZone = ZoneId.systemDefault();
        ZoneOffset zoneOffset = systemZone.getRules().getOffset(time);
        return time.toInstant(zoneOffset).getEpochSecond();
    }

    public static LocalDateTime secondTimestampToDate(Long secondTimestamp) {
        if (secondTimestamp == null || secondTimestamp <= 0) {
            return null;
        }
        Instant instant = Instant.ofEpochSecond(secondTimestamp);
        LocalDateTime time = LocalDateTime.ofInstant(instant, DateUtils.SYSTEM_ZONE);
        return time;
    }

    public static Integer curTimestamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String parseTimestamp(Integer cashoutTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        return sdf.format((long) cashoutTime * 1000L);
    }

    public static Integer getTimestamp(String timestr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
            return (int) (sdf.parse(timestr).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Integer getTimestamp(String timestr, SimpleDateFormat sdf) {
        try {
            return (int) (sdf.parse(timestr).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Integer getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int firstDay = cal.getMinimum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return (int) (cal.getTime().getTime() / 1000);
    }

    public static Integer getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return (int) (cal.getTime().getTime() / 1000);
    }

    public static long getZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero.getTime();
    }

    /**
     * 获取昨天开始的时间
     */
    public static Date getYesterdayStartTime() {
        Calendar dateStart = Calendar.getInstance();
        dateStart.add(Calendar.DATE, -1);
        dateStart.set(Calendar.HOUR_OF_DAY, 0);
        dateStart.set(Calendar.MINUTE, 0);
        dateStart.set(Calendar.SECOND, 0);
        return dateStart.getTime();
    }

    /**
     * 获取昨天结束的时间
     */
    public static Date getYesterdayEndTime() {
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.add(Calendar.DATE, -1);
        dateEnd.set(Calendar.HOUR_OF_DAY, 23);
        dateEnd.set(Calendar.MINUTE, 59);
        dateEnd.set(Calendar.SECOND, 59);
        return dateEnd.getTime();
    }


    /**
     * 获取本周的开始时间
     */
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return startOfDate(cal.getTime());
    }

    /**
     * 获取本周的结束时间
     */
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return endOfDate(weekEndSta);
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past 几天前
     * @param date 日期
     * @return
     */
    public static Date getPastDate(int past, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past + 1);
        return calendar.getTime();
    }

    /**
     * 获取一年前的时间
     */
    public static Date getOneYearAgo() {
        Calendar dateStart = Calendar.getInstance();
        dateStart.add(Calendar.YEAR, -1);
        dateStart.set(Calendar.HOUR_OF_DAY, 0);
        dateStart.set(Calendar.MINUTE, 0);
        dateStart.set(Calendar.SECOND, 0);
        return dateStart.getTime();
    }

    /**
     * 获取过去某月时间
     */
    public static Date getSomeMonthAgo(Integer month) {
        Calendar dateStart = Calendar.getInstance();
        dateStart.add(Calendar.MONTH, -month);
        dateStart.set(Calendar.HOUR_OF_DAY, 0);
        dateStart.set(Calendar.MINUTE, 0);
        dateStart.set(Calendar.SECOND, 0);
        return dateStart.getTime();
    }

    /**
     * 获取当前时间戳（单位/秒）
     *
     * @return 时间戳
     */
    public static int getCurrentTimeMillis() {
        return (int) DateUtils.getSecondTimestamp(LocalDateTime.now());
    }

    /**
     * 获取指定时间的时间戳（单位/秒）
     *
     * @return 时间戳
     */
    public static Integer getTimeMillis(String dateStr) {
        try {
            Date date = DateUtils.parseDate(dateStr);
            if (date != null) {
                return (int) (date.getTime() / 1000);
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    /**
     * 获取指定时间的时间戳（单位/秒）
     *
     * @return 时间戳
     */
    public static Integer getTimeMillis(Date date) {
        try {
            if (date != null) {
                return (int) (date.getTime() / 1000);
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }


    /**
     * 获取当前时间（Date类型）
     *
     * @return 当前时间
     */
    public static Date getCurrentDate() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 当前时间戳 单位秒
     *
     * @return
     */
    public static int now() {
        return ((int) (System.currentTimeMillis() / 1000));
    }

    public static long dateToTimestamp(String date) {
        return DateUtils.dateToTimestamp(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static long dateToTimestamp(String date, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(date).getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    public static long dateToIntTimestamp(String date) {
        long timestamp = DateUtils.dateToTimestamp(date, "yyyy-MM-dd HH:mm:ss");
        return (int) (timestamp / 1000);
    }


    public static long getTsOfTodayBeforDawn() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static String listToString(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : list) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }
}
