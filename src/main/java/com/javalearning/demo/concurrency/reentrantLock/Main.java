package com.javalearning.demo.concurrency.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lhh
 * @date 2021/3/30
 */
public class Main {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    lock();
                }
            });
        }

        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }

        Thread.sleep(10000);
    }

    private static void lock() {
        reentrantLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("handling..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
