package com.javalearning.demo.concurrency.concurrency_collection.delayed_queue;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 队列中的元素按过期时间排序，早过期的先出列，而且这个列表是并发安全的。
        // 适用于要自定义时间处理任务的场景
        DelayQueue<Event> queue = new DelayQueue<>();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(i + 1, queue);
            Thread thread = new Thread(task);
            threads[i] = thread;
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        do {
            int counter = 0;
            Event event;
            do {
                event = queue.poll();
                if (event != null){
                    counter ++;
                }
            }while (event != null);

            System.out.printf("At %s you have read %d events\n", new Date(), counter);
            TimeUnit.MILLISECONDS.sleep(500);
        }while (queue.size() > 0);
    }
}
