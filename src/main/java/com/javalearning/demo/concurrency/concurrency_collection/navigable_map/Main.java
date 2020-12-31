package com.javalearning.demo.concurrency.concurrency_collection.navigable_map;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();

        Thread[] threads = new Thread[25];
        int counter = 0;

        for (char i = 'A'; i < 'Z'; i++) {
            Task task = new Task(String.valueOf(i), map);
            Thread thread = new Thread(task);

            threads[counter] = thread;
            threads[counter].start();
            counter ++;
        }

        for (int i = 0; i < counter; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: size of the map: %d \n", map.size());
        Map.Entry<String, Contact> element;
        Contact contact;

        element = map.firstEntry();
        contact = element.getValue();

        System.out.printf("Main: first entry: %s : %s \n", contact.getName(), contact.getPhone());

        element = map.lastEntry();
        contact = element.getValue();
        System.out.printf("Main: last entry: %s : %s \n", contact.getName(), contact.getPhone());

        System.out.printf("Main: Submap from A1996 to B1002: \n");
        ConcurrentNavigableMap<String, Contact> subMap = map.subMap("A1996", "B1002");

        do {
            element = subMap.pollFirstEntry();
            if (element != null){
                contact = element.getValue();
                System.out.printf("%s : %s \n", contact.getName(), contact.getPhone());
            }
        }while (element != null);



    }
}
