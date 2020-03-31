package com.javalearning.demo.review.ningmenghuokeji;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class review3 {

    public static List<Long> nofushu(List<Integer> list){
        List<Integer> collect = list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        }).collect(Collectors.toList());
        List<Long> result = new ArrayList<>();
        for (Integer integer : collect) {
            Long l = Long.valueOf(integer);
            result.add(l);
        }
        return result;
    }

    public static void printListUseStream(List<Integer> list){
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        list.forEach((integer -> System.out.println(integer)));
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-2);
        list.add(0);
        list.add(5);
        list.add(-9);
        list.add(8);
        list.add(7);

        List<Long> nofushu = nofushu(list);
        System.out.println(nofushu);

        printListUseStream(list);


    }
}
