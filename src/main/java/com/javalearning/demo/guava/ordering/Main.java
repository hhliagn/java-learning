package com.javalearning.demo.guava.ordering;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Ordering<String> ordering = new Ordering<String>() {
            @Override
            public int compare(@Nullable String s, @Nullable String t1) {
                return Ints.compare(s.length(), t1.length());
            }
        };

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add(null);
        list.add("ccc");
        list.add("zz");
        list.add("y");
        System.out.println(list);


//        Collections.sort(list, ordering);
//        System.out.println(list);


//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Ints.compare(o1.length(), o2.length());
//            }
//        };
//
//        Ordering<String> from = Ordering.from(comparator);
//        Collections.sort(list, from);
//        System.out.println(list);


//        Ordering<Comparable> natural = Ordering.natural();
//        Collections.sort(list, natural);
//        System.out.println(list);


//        Ordering<Object> usingToString = Ordering.usingToString();
//        Collections.sort(list, usingToString);
//        System.out.println(list);


//        Ordering<Comparable> reverse = Ordering.natural().reverse();
//        Collections.sort(list, reverse);
//        System.out.println(list);


//        Ordering<Comparable> nullsFirst = Ordering.natural().nullsFirst();
//        Collections.sort(list, nullsFirst);
//        System.out.println(list);


//        Ordering<Comparable> nullLast = Ordering.natural().nullsLast();
//        Collections.sort(list, nullLast);
//        System.out.println(list);


        // NPE
//        Ordering<Comparable> hasNull = Ordering.natural();
//        Collections.sort(list, hasNull);
//        System.out.println(list);


//        Ordering<String> natural = Ordering.natural();
//        Ordering<Iterable<String>> lexicographical = natural.lexicographical();
//        Collections.sort(list, lexicographical);
//        System.out.println(list);
    }
}
