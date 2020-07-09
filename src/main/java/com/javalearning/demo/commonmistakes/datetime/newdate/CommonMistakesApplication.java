package com.javalearning.demo.commonmistakes.datetime.newdate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CommonMistakesApplication {

    public static void main(String[] args) {
        wrong();
        System.out.println();
        wrong2();
        System.out.println();
        right();
        System.out.println();
        right2();
        System.out.println();
    }

    private static void wrong(){
        System.out.println("wrong");
        Date date = new Date(2019, 12, 31, 11, 12, 13);
        System.out.println(date);
    }

    private static void wrong2(){
        System.out.println("wrong2");
        Date date = new Date(2019 - 1990, 11, 31, 11, 12, 13);
        System.out.println(date);
    }

    private static void right(){
        System.out.println("right");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 31, 11, 12, 13);
        System.out.println(calendar.getTime());

        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        calendar2.set(2019, Calendar.DECEMBER, 31, 11, 12, 13);
        System.out.println(calendar2.getTime());
    }

    //同一个时间，不同时区，读到的时间不一样
    //不同时间，经过不同的时区，格式化后的时间可能相同
    private static void right2(){
        LocalDateTime localDateTime
                = LocalDateTime.of(2019, 12, 31, 11, 12, 13);
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime2);
    }
}

