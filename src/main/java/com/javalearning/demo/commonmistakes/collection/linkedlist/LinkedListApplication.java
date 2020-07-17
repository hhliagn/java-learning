package com.javalearning.demo.commonmistakes.collection.linkedlist;

import org.springframework.util.Assert;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedListApplication {

    public static void main(String[] args) {
        int elementCount = 100000;
        int loopCount = 100000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("linkedListGet");
        linkedListGet(elementCount, loopCount);
        stopWatch.stop();
        stopWatch.start("arrayListGet");
        arrayListGet(elementCount, loopCount);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start("linkedListAdd");
        linkedListAdd(elementCount, loopCount);
        stopWatch2.stop();
        stopWatch2.start("arrayListAdd");
        arrayListAdd(elementCount, loopCount);
        stopWatch2.stop();
        System.out.println(stopWatch2.prettyPrint());
    }

    private static void linkedListGet(Integer elementCount, Integer loopCount){
        List<Integer> linkedList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int index = ThreadLocalRandom.current().nextInt(elementCount);
            Integer num = linkedList.get(index);
            Assert.isTrue(num != null);
        });
    }

    private static void arrayListGet(Integer elementCount, Integer loopCount){
        List<Integer> arrayList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int index = ThreadLocalRandom.current().nextInt(elementCount);
            Integer num = arrayList.get(index);
            Assert.isTrue(num != null);
        });
    }

    private static void linkedListAdd(Integer elementCount, Integer loopCount){
        List<Integer> linkedList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int index = ThreadLocalRandom.current().nextInt(elementCount);
            linkedList.add(index, 1);
        });
    }

    private static void arrayListAdd(Integer elementCount, Integer loopCount){
        List<Integer> arrayList = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int index = ThreadLocalRandom.current().nextInt(elementCount);
            arrayList.add(index,1);
        });
    }
}

