package com.javalearning.demo.concurrency.thread_pool.demo;

import jodd.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GlobalThreadPool {

    private static ThreadPoolExecutor threadPoolExecutor;

    public static ThreadPoolExecutor getThreadPoolExecutor(){
        if (threadPoolExecutor != null){
            return threadPoolExecutor;
        }

        synchronized (GlobalThreadPool.class){
            if (threadPoolExecutor != null){
                return threadPoolExecutor;
            }

            threadPoolExecutor = new ThreadPoolExecutor(
                    100, 500,
                    1, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(500),
                    new ThreadFactoryBuilder().setNameFormat("bg-upload-%d").get(),
                    new ThreadPoolExecutor.AbortPolicy());

            return threadPoolExecutor;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = GlobalThreadPool.getThreadPoolExecutor();

        for (int g = 0; g < 1000; g++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            };

            threadPoolExecutor.submit(runnable);
        }

        threadPoolExecutor.awaitTermination(15, TimeUnit.SECONDS);
        threadPoolExecutor.shutdown();
    }
}
