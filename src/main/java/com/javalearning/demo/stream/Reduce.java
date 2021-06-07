package com.javalearning.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lhh
 * @date 2021/6/5
 */
public class Reduce {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l; },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1; });

        System.out.println(numbers);

        //BinaryOperator

        //numbers.stream().collect()
        //Collectors.groupingBy()
    }
}
