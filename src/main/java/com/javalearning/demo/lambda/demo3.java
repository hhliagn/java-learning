package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class demo3 {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        filter(languages, s -> s.startsWith("J"));
        filter(languages, s -> s.startsWith("A"));

        System.out.println("==========================");

        filter_lambda(languages, s -> s.startsWith("J"));
        filter_lambda(languages, s -> s.startsWith("A"));
    }

    public static void filter(List<String> names, Predicate<String> condition){
        for (String name : names) {
            if (condition.test(name)){
                System.out.println(name);
            }
        }
    }

    public static void filter_lambda(List<String> names, Predicate<String> condition){
        names.stream().filter((str) -> (condition.test(str))).forEach(name -> System.out.println(name));
    }
}
