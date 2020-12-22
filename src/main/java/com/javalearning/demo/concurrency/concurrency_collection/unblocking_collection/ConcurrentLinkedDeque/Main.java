package com.javalearning.demo.concurrency.concurrency_collection.unblocking_collection.ConcurrentLinkedDeque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static void main(String[] args) {
        // ConcurrentLinkedDeque: 并发操作同一个list并不会发生数据错误
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();

        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            AddTask addTask = new AddTask(list);
            threads[i] = new Thread(addTask);
            threads[i].start();
        }

        System.out.printf("Main: %d AddTask have been launched.\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the List: %d\n", list.size());

        for (int i = 0; i < threads.length; i++) {
            PollTask pollTask = new PollTask(list);
            threads[i] = new Thread(pollTask);
            threads[i].start();
        }

        System.out.printf("Main: %d PollTask have been launched.\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the List: %d\n", list.size());

        /**
         * LinkedList:
         * Main: 100 AddTask have been launched.
         * Main: Size of the List: 566751
         * Main: 100 PollTask have been launched.
         * Main: Size of the List: 566654
         *
         * ConcurrentLinkedDeque:
         * Main: 100 AddTask have been launched.
         * Main: Size of the List: 1000000
         * Main: 100 PollTask have been launched.
         * Main: Size of the List: 0
         */
    }
}
