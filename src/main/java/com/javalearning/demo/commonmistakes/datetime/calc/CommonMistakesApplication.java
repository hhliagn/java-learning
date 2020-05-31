package com.javalearning.demo.commonmistakes.datetime.calc;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;

public class CommonMistakesApplication {

    public static void main(String[] args) throws Exception {
        wrong1();
        wrong1fix();
        right();
        better();
//        test();

        System.out.println(daysBetween(new Date(), new Date()));
    }

    private static void wrong1() {
        System.out.println("wrong1");
        Date date = new Date();
        Date oneMonthLater = new Date(date.getTime() + 30 * 24 * 3600 * 1000);
        System.out.println(date);
        System.out.println(oneMonthLater);
    }

    private static void wrong1fix() {
        System.out.println("wrong1fix");
        System.out.println(30 * 24 * 3600 * 1000 + " " + (30 * 24 * 3600 * 1000 > Integer.MAX_VALUE));
        Date date = new Date();
        Date oneMonthLater = new Date(date.getTime() + 30L * 24 * 3600 * 1000);
        System.out.println(date);
        System.out.println(oneMonthLater);
    }

    private static void right() {
        System.out.println("right");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, 1);
        System.out.println(c.getTime());
    }

    private static void better() {
        System.out.println("better");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthLater = now.plusDays(30);
        System.out.println(oneMonthLater);
    }

    private static void test() {
        System.out.println("//测试操作日期");
        System.out.println(LocalDate.now()
                .minus(Period.ofDays(1))
                .plus(1, ChronoUnit.DAYS)
                .minusMonths(1)
                .plus(Period.ofMonths(1)));

        System.out.println("//计算日期差");
        LocalDate today = LocalDate.of(2019, 12, 12);
        LocalDate specifyDate = LocalDate.of(2019, 10, 1);
        System.out.println(Period.between(specifyDate, today).getDays());
        System.out.println(Period.between(specifyDate, today));
        System.out.println(ChronoUnit.DAYS.between(specifyDate, today));


        System.out.println("//本月的第一天");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

        System.out.println("//今年的程序员日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).plusDays(255));

        System.out.println("//今天之前的一个周六");
        System.out.println(LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));

        System.out.println("//本月最后一个工作日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));

        System.out.println("//自定义逻辑");
        System.out.println(LocalDate.now().with(temporal -> temporal.plus(ThreadLocalRandom.current().nextInt(100), ChronoUnit.DAYS)));

        System.out.println("//查询是否是今天要举办生日");
        System.out.println(LocalDate.now().query(CommonMistakesApplication::isFamilyBirthday));

    }

    public static Boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(MONTH_OF_YEAR);
        int day = date.get(DAY_OF_MONTH);

        if (month == Month.FEBRUARY.getValue() && day == 17)
            return Boolean.TRUE;
        if (month == Month.SEPTEMBER.getValue() && day == 21)
            return Boolean.TRUE;
        if (month == Month.MAY.getValue() && day == 22)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    /** 使用Calenaa 判断两个日期差*/
    public static long daysBetween(Date date1, Date date2){

        Calendar c = Calendar.getInstance();
        c.set(2020,Calendar.JANUARY,1);
        Calendar c2 = Calendar.getInstance();
        c.set(2020,Calendar.MAY, 20);

        Date t1 = c.getTime();
        Date t2 = c2.getTime();

        return (t2.getTime() - t1.getTime()) / (1000 * 3600 * 24);
    }
}

