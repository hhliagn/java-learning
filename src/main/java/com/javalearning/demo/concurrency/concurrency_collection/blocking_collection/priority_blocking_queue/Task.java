package com.javalearning.demo.concurrency.concurrency_collection.blocking_collection.priority_blocking_queue;

import java.util.PriorityQueue;

public class Task implements Runnable{

    private int id;
    private PriorityQueue<Event> queue;

    public Task(int id, PriorityQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event event = new Event(id, i);
            queue.add(event);
        }
    }
}
