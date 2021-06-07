package com.javalearning.demo.stream.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlatMap {

    public static void main(String[] args) {

        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");

        List<String> collect = streamOfwords
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(collect);
    }
}



