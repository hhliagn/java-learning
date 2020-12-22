package com.javalearning.demo.concurrency.concurrency_collection.unblocking_collection.ConcurrentLinkedDeque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable{

    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}
