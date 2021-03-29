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

            /**
             * 新任务到达：
             * 当前运行线程数 <  核心线程数：创建新线程，即使有空闲线程
             * 当前运行线程数 >= 核心线程数: 只有当队列满了才会创建新线程
             *
             * 队列：
             * SynchronousQueue：
             *  如果当前没有空闲线程处理任务时，立刻创建新线程来处理，一般配合无限大的最大线程数使用避免触发拒绝策略，
             *  如果任务到达速度远远大于任务处理速度，会导致线程无限增长
             *
             * LinkedBlockingQueue：
             *  当每个任务完全独立于其他任务时，适合使用，如果任务到达速度远远大于任务处理速度，会导致线程无限增长
             *
             * ArrayBlockingQueue：
             *  IO 等阻塞任务应该用更多的线程数，计算量大的任务应该用更大的队列
             *  大队列小池：吞吐量小，CPU空闲，资源占用小，小的上下文切换开销
             *  小队列大池：吞吐量大，CPU繁忙，大的上下文切换开销也可能导致吞吐量减少
             *
             * 拒绝策略：
             * ThreadPoolExecutor.AbortPolicy：抛出运行时异常
             * ThreadPoolExecutor.CallerRunsPolicy: 调用线程执行
             * ThreadPoolExecutor.DiscardPolicy：简单丢弃
             * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列头部的线程，导致拒绝的线程会重复执行，可能会再次失败
             */
            threadPoolExecutor = new ThreadPoolExecutor(
                    100, 500,
                    1, TimeUnit.MINUTES, // 闲置线程回收时间
                    new ArrayBlockingQueue<>(500), // 等待执行的线程队列，只有通过submit进来的runnable会入队
                    new ThreadFactoryBuilder().setNameFormat("bg-upload-%d").get(), // 设置线程名
                    new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略，当线程达到最大数量或达到队列上限时丢弃

            threadPoolExecutor.prestartAllCoreThreads(); // 提前开启所有核心线程（当队列不为空时）

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
