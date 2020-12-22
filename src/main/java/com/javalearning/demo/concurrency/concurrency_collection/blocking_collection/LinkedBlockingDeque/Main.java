package com.javalearning.demo.concurrency.concurrency_collection.blocking_collection.LinkedBlockingDeque;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);

        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    // 如果集合为空，这个操作会阻塞直到集合有新的元素加入
                    String take = list.take();
                    System.out.printf("Main: %s at %s, Size: %s\n", list, new Date(), list.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main End.");
    }
}
