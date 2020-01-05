package com.javalearning.demo.test.hoding.ListIteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        List<Integer> int1 = new ArrayList<>();
        int1.add(10);
        int1.add(20);
        int1.add(30);
        List<Integer> int2 = new ArrayList<>();
        ListIterator<Integer> it1 = int1.listIterator();
        while (it1.hasNext()){
            System.out.print(it1.next() + " ");
        }
        while (it1.hasPrevious()){
            Integer previous = it1.previous();
            int2.add(previous);
        }
        System.out.println(int2);
    }
}
