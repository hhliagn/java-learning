package com.javalearning.demo.commonmistakes.newdate;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @description cc
 * @date 2020/5/13
 */
public class CommonMistakeApplication {

    @Test
    public void wrong(){
        Date date = new Date(2019, 12, 31, 11, 12, 13);
        System.out.println(date);
    }

    @Test
    public void wrongfix(){
        Date date = new Date(2019 - 1900, 11, 31, 11, 12, 13);
        System.out.println(date);
    }

    @Test
    public void right(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 31, 11, 12, 13);
        System.out.println(calendar.getTime());

        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        calendar2.set(2019, Calendar.DECEMBER, 31, 11, 12, 13);
        System.out.println(calendar2.getTime());
    }
}
