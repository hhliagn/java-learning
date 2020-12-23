package com.javalearning.demo.concurrency.concurrency_collection.blocking_collection.priority_blocking_queue;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Event> queue = new PriorityQueue<>();

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {

            Task task = new Task(i, queue);
            Thread thread = new Thread(task);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Queue Size: %d\n",queue.size());

        for (int i = 0; i < threads.length * 1000; i++) {
            Event event = queue.poll();
            System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
        }

        System.out.printf("Main: Queue Size: %d\n",queue.size());
        System.out.println("Main: End");
    }
}
