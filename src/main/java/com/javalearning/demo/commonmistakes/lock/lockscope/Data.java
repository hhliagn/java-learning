package com.javalearning.demo.commonmistakes.lock.lockscope;

import lombok.Getter;

public class Data {

    @Getter
    private static int counter = 0;
    private static Object lock = new Object();

    public static int reset(){
        counter = 0;
        return counter;
    }

    public synchronized void wrong(){
        counter ++;
    }

    public void right(){
        synchronized (lock){
            counter ++;
        }
    }
}
