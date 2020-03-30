package com.javalearning.demo.test.containers;

import java.util.*;

public class SortedSetDemo {
    public static void main(String[] args) {
        String str = "one two three four five six seven eight nine ten";
        String[] s = str.split(" ");
        List<String> strings = Arrays.asList(s);
        SortedSet<String> sortedSet = new TreeSet<>(strings);
        System.out.println(sortedSet);

        String first = sortedSet.first();
        String last = sortedSet.last();

        Iterator<String> it = sortedSet.iterator();
        String low = null;
        String high = null;
        for (int i = 0; i <= 6; i++) {
            if (i == 3){
                low = it.next();
            }
            if (i == 6){
                high = it.next();
            }
            it.next();
        }
        System.out.println("first: " + first);
        System.out.println("last: " + last);
        System.out.println("low: " + low);
        System.out.println("high: " + high);

        SortedSet<String> subSet = ((TreeSet<String>) sortedSet).subSet(low, high);
        SortedSet<String> headSet = ((TreeSet<String>) sortedSet).headSet(low);
        SortedSet<String> tailSet = ((TreeSet<String>) sortedSet).tailSet(high);

        System.out.println("subSet: " + subSet);
        System.out.println("headSet: " + headSet);
        System.out.println("tailSet: " + tailSet);

        /**
         * output:
         * [eight, five, four, nine, one, seven, six, ten, three, two]
         * first: eight
         * last: two
         * low: nine
         * high: ten
         * subSet: [nine, one, seven, six]
         * headSet: [eight, five, four]
         * tailSet: [ten, three, two]
         */
    }
}
