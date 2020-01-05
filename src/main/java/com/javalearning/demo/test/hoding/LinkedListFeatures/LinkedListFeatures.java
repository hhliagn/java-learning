package com.javalearning.demo.test.hoding.LinkedListFeatures;

import java.util.LinkedList;
import java.util.List;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Integer> pets =new LinkedList<Integer>();
        pets.add(10);
        pets.add(20);
        pets.add(30);
        pets.add(40);
        pets.add(50);
        pets.add(60);

        System.out.println(pets);

        System.out.println("get first: " + pets.getFirst());
        System.out.println(pets);

        System.out.println("get last " + pets.getLast());
        System.out.println(pets);

        System.out.println("peek " + pets.peek());
        System.out.println(pets);

        System.out.println("remove " + pets.remove());
        System.out.println(pets);

        System.out.println("remove first " + pets.removeFirst());
        System.out.println(pets);

        System.out.println("poll " + pets.poll());
        System.out.println(pets);

        System.out.println("remove last " + pets.removeLast());
        System.out.println(pets);

        pets.addFirst(1000);
        System.out.println("addFirst " + pets);
        pets.addLast(2000);
        System.out.println("addLast " + pets);
        pets.add(3000);
        System.out.println("add " + pets);

        boolean offer = pets.offer(5000);
        System.out.println("offer " + pets);
    }
}
