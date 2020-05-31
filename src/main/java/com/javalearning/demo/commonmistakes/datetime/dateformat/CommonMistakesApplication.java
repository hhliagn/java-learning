package com.javalearning.demo.commonmistakes.datetime.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CommonMistakesApplication {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> threadSafeSimpleDateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private static DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR)
            .appendLiteral("/")
            .appendValue(ChronoField.MONTH_OF_YEAR)
            .appendLiteral("/")
            .appendValue(ChronoField.DAY_OF_MONTH)
            .appendLiteral(" ")
            .appendValue(ChronoField.HOUR_OF_DAY)
            .appendLiteral(":")
            .appendValue(ChronoField.MINUTE_OF_HOUR)
            .appendLiteral(":")
            .appendValue(ChronoField.SECOND_OF_MINUTE)
            .appendLiteral(".")
            .appendValue(ChronoField.MILLI_OF_SECOND)
            .toFormatter();

    public static void main(String[] args) throws Exception {

//        wrong1();
//        wrong1fix();

        better();

//        wrong2();
//        wrong2fix();

//        right();
    }

    private static void test(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
        System.out.println(dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault())));
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
    }


    private static void wrong1() throws ParseException {
        //三个问题，YYYY、线程不变安全、不合法格式

        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);

        Locale.setDefault(Locale.FRANCE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.DECEMBER, 31, 0, 0, 0);

        SimpleDateFormat YYYY = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("格式化: " + YYYY.format(calendar.getTime()));
        System.out.println("weekYear:" + calendar.getWeekYear());
        System.out.println("firstDayOfWeek:" + calendar.getFirstDayOfWeek());
        System.out.println("minimalDaysInFirstWeek:" + calendar.getMinimalDaysInFirstWeek());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String dateString = "20190602";
        System.out.println(simpleDateFormat.parse(dateString));
    }

    private static void wrong1fix() throws ParseException {
        String dateString = "20190602";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        System.out.println(simpleDateFormat.parse(dateString));
    }

    private static void better() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2019-12-02 12:03:45", dateTimeFormatter);

        String format = parse.format(dateTimeFormatter);
        System.out.println(format);

        //DateTimeFormatter 严格校验
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyyMM");
        TemporalAccessor parse1 = dateTimeFormatter1.parse("20190603");
        System.out.println(parse1);
    }

    private static void wrong2() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                for (int g = 0; g < 10; g++) {
                    try {
                        System.out.println(simpleDateFormat.parse("2020-01-02 12:13:14"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

    private static void wrong2fix() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    try {
                        System.out.println(threadSafeSimpleDateFormat.get().parse("2020-01-02 12:13:14"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void right() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    System.out.println(dateTimeFormatter.parse("2020/01/02 11:12:13.374"));
                }
            });
        }
    }
}

