package com.javalearning.demo.concurrency.thread_local;

public class Task1 implements Runnable {

    @Override
    public void run() {
        ThreadLocalHelper.set("Task1");
        System.out.println(Thread.currentThread().getName() + ": " + ThreadLocalHelper.get());
    }
}
