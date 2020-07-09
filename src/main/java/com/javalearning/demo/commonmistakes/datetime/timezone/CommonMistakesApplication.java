package com.javalearning.demo.commonmistakes.datetime.timezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class CommonMistakesApplication {

    public static void main(String[] args) throws Exception {
        test();
        wrong1();
        wrong2();
        right();
    }

    private static void test(){
        System.out.println("test");
        System.out.println(new Date(0));
        System.out.println(TimeZone.getDefault().getID() + " " + TimeZone.getDefault().getRawOffset() / (3600 * 1000));
    }

    private static void wrong1() throws ParseException {
        // 同一个时间，不同的时区，解析的结果不同
        System.out.println("wrong1");
        String dateString = "2019-06-02 12:13:14";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(dateString);

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date parse1 = simpleDateFormat.parse(dateString);

        System.out.println(parse);
        System.out.println(parse1);
    }

    private static void wrong2() throws ParseException {
        //同一个时间，不同的时区，格式化的结果不同
        System.out.println("wrong2");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        String format1 = simpleDateFormat.format(date);

        System.out.println(format);
        System.out.println(format1);
    }

    private static void right(){
        //dateTimeFormatter 格式化带时区的时间才能看出区别
        String dateString = "2020-02-03 12:13:14";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        ZoneId timezoneSH = ZoneId.of("Asia/Shanghai");
        ZoneId timezoneNY = ZoneId.of("America/New_York");
        ZoneId timezoneJST = ZoneOffset.ofHours(9);

        LocalDateTime parse = LocalDateTime.parse(dateString, dateTimeFormatter);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(parse, timezoneSH);

        System.out.println(dateTimeFormatter.withZone(timezoneNY).format(zonedDateTime1));
        System.out.println(dateTimeFormatter.withZone(timezoneSH).format(zonedDateTime1));
        System.out.println(dateTimeFormatter.withZone(timezoneJST).format(zonedDateTime1));
    }
}

