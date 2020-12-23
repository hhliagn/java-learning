package com.javalearning.demo.concurrency.concurrency_collection.blocking_collection.priority_blocking_queue;


import lombok.Data;

@Data
public class Event implements Comparable<Event>{

    private int thread;
    private int priority;

    public Event(int thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    @Override
    public int compareTo(Event o) {
        // 这里和一般的compare相反，小的放在后面，所以出队的时候小的最后出
        if (this.getPriority() < o.getPriority()) return 1;
        else if (this.getPriority() > o.getPriority()) return -1;
        else return 0;
    }
}
