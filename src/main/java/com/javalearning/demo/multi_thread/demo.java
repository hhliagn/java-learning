package com.javalearning.demo.multi_thread;

public class demo {
    private static long counter = 0;
    public static void main(String[] args) {

        Integer.valueOf(10);
        //多线程操作公共变量，会有安全问题，数据出错
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (counter == 0){
                        System.out.println(Thread.currentThread().getName() + "aaa");
                    }else {
                        System.out.println(Thread.currentThread().getName() + "bbb");
                    }
                    counter = 1;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (counter == 1){
                        System.out.println(Thread.currentThread().getName() + "bbb");
                    }else {
                        System.out.println(Thread.currentThread().getName() + "aaa");
                    }
                    counter = 0;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread-2").start();
    }
}
