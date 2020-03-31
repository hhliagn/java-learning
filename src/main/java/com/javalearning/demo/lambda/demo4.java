package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class demo4 {

    // 使用 and 连接两个Predicate 进行过滤
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");
        languages.stream().filter(p1).forEach(n -> System.out.println(n));
        System.out.println("==================");
        languages.stream().filter(p1.and(p2)).forEach(n -> System.out.println(n));
    }
}
