package com.javalearning.demo.commonmistakes.lock.lockscope;

import lombok.Getter;

import java.util.stream.IntStream;

public class Data {
    @Getter
    private static int counter;
    private static Object locker = new Object();

    public synchronized void wrong(){
        counter++;
    }

    public void right(){
        synchronized (locker){
            counter++;
        }
    }

    public static void main(String[] args) {
//        IntStream.rangeClosed(1,1000000).parallel().forEach(i->new Data().wrong());
        IntStream.rangeClosed(1,1000000).parallel().forEach(i->new Data().right());
        System.out.println(Data.getCounter());
    }

}
