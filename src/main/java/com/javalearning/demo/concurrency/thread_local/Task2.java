package com.javalearning.demo.concurrency.thread_local;

public class Task2 implements Runnable {

    @Override
    public void run() {
        ThreadLocalHelper.set("Task2");
        System.out.println(Thread.currentThread().getName() + ": " + ThreadLocalHelper.get());
    }
}
