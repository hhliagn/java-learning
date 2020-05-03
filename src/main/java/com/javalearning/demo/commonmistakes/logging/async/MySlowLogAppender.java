package com.javalearning.demo.commonmistakes.logging.async;

import ch.qos.logback.core.ConsoleAppender;

import java.util.concurrent.TimeUnit;

public class MySlowLogAppender extends ConsoleAppender {

    @Override
    protected void subAppend(Object event) {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.subAppend(event);
    }
}
