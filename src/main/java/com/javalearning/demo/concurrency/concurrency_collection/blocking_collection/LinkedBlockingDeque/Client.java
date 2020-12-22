package com.javalearning.demo.concurrency.concurrency_collection.blocking_collection.LinkedBlockingDeque;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {

    private LinkedBlockingDeque<String> list;

    public Client(LinkedBlockingDeque<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append(":");
                stringBuilder.append(j);

                try {
                    list.put(stringBuilder.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("Client: %s at %s\n", list, new Date());
            }

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Client End.");
    }
}
