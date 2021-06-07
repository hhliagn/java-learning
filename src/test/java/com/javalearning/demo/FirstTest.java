package com.javalearning.demo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lhh
 * @date 2021/5/13
 */
public class FirstTest {

    @Test(timeout = 1000)
    public void testTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("complete..");
    }

    @Test(expected = NullPointerException.class)
    public void testNPE() {
        throw new NullPointerException();
    }
}