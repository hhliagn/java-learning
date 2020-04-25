package com.javalearning.demo.commonmistakes.collection.sublist;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class sublist_oom {

    private static List<List<Integer>> rs = new ArrayList<>();

    public static void main(String[] args) {
//        oom();
//        oom_fix();

//        wrong1();
//        right1();
        right2();
    }

    //强引用
    private static void oom(){
        IntStream.rangeClosed(1,1000).forEach(i->{
            List<Integer> list = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList());
            rs.add(list.subList(0,1));
        });
        log.info("Done");
    }

    private static void oom_fix(){
        IntStream.rangeClosed(1,1000).forEach(i->{
            List<Integer> list = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList());
            rs.add(new ArrayList<>(list.subList(0,1)));
        });
        log.info("Done");
    }

    //增加后迭代
    private static void wrong1(){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> subList = list.subList(1, 4);
        log.info("subList: {}, before remove", subList);
        subList.remove(1);
        log.info("list: {}, subList: {}", list, subList);
        list.add(0);
        subList.forEach(System.out::println);
    }

    private static void right1(){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> subList = new ArrayList<>(list.subList(1,4));
        log.info("subList: {}, before remove", subList);
        subList.remove(1);
        log.info("list: {}, subList: {}", list, subList);
        list.add(0);
        subList.forEach(System.out::println);
    }

    private static void right2(){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> subList = list.stream().skip(1).limit(3).collect(Collectors.toList());
        log.info("subList: {}, before remove", subList);
        subList.remove(1);
        log.info("list: {}, subList: {}", list, subList);
        list.add(0);
        subList.forEach(System.out::println);
    }
}
