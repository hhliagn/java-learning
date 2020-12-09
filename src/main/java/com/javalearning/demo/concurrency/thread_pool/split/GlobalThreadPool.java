package com.javalearning.demo.concurrency.thread_pool.split;

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

            threadPoolExecutor = new ThreadPoolExecutor(100, 500, 1, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(500), new ThreadPoolExecutor.CallerRunsPolicy());
            return threadPoolExecutor;
        }
    }

}
