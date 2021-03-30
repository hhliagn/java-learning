package com.javalearning.demo.reflect;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author lhh
 * @date 2021/3/30
 */
public class Demo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar now = Calendar.getInstance();
        Date time = now.getTime();
        MyTask myTask = new MyTask();
        timer.schedule(myTask, time, 1000);
    }
}
