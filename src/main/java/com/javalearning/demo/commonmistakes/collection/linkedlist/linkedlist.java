package com.javalearning.demo.commonmistakes.collection.linkedlist;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class linkedlist {

    private static int elementCount = 100000;
    private static int loopCount = 100000;

    public static void main(String[] args) {
//        StopWatch stopWatch1 = new StopWatch();
//        stopWatch1.start("array list get");
//        arraylistget();
//        stopWatch1.stop();
//        stopWatch1.start("linked list get");
//        linkedlistget();
//        stopWatch1.stop();
//        System.out.println(stopWatch1.prettyPrint());

        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start("array list add");
        arraylistadd();
        stopWatch2.stop();
        stopWatch2.start("linked list add");
        linkedlistadd();
        stopWatch2.stop();
        System.out.println(stopWatch2.prettyPrint());

    }

    private static void arraylistget(){
        ArrayList<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1,loopCount).forEach(i->list.get(ThreadLocalRandom.current().nextInt(list.size())));
    }

    private static void linkedlistget(){
        LinkedList<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1,loopCount).forEach(i->list.get(ThreadLocalRandom.current().nextInt(list.size())));
    }

    private static void arraylistadd(){ //2s
        ArrayList<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1,loopCount).forEach(i->list.add(ThreadLocalRandom.current().nextInt(list.size()), 1));
    }

    private static void linkedlistadd(){ //86s
        LinkedList<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1,loopCount).forEach(i->list.add(ThreadLocalRandom.current().nextInt(list.size()), 1));
    }
}
