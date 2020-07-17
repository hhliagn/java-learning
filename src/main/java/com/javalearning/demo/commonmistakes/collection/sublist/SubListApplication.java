package com.javalearning.demo.commonmistakes.collection.sublist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubListApplication {

    public static void main(String[] args) {
//        wrong();
//        System.out.println();
//        right1();
//        System.out.println();
//        right2();

//        oom();
        oomfix();
    }

    private static List<List<Integer>> data = new ArrayList<>();

    private static void wrong(){
        List<Integer> list = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        List<Integer> subList = list.subList(1, 3);
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        try {
            subList.forEach(System.out::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void oom(){
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0,1));
        });
    }

    private static void oomfix(){
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(new ArrayList<>(rawList.subList(0,1)));
        });
    }

    private static void wrong2(){

    }

    private static void right1(){
        List<Integer> list = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        List<Integer> subList = new ArrayList<>(list.subList(1, 3));
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        try {
            subList.forEach(System.out::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void right2(){
        List<Integer> list = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        List<Integer> subList = list.stream().skip(1).limit(3).collect(Collectors.toList());
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        try {
            subList.forEach(System.out::print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

