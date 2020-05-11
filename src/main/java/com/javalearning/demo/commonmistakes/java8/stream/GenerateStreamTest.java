package com.javalearning.demo.commonmistakes.java8.stream;

import org.junit.Test;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description
 * @date 2020/5/11
 */
public class GenerateStreamTest {

    @Test
    public void stream(){
        int[] ints = {1, 2, 3};
        Arrays.asList("a", "b", "c").stream().forEach(System.out::println);
        Arrays.stream(ints).forEach(System.out::println);
    }

    @Test
    public void of(){
        String[] arr = {"a","b","c"};
        Stream.of(arr).forEach(System.out::println);
        Stream.of("a","b","c").forEach(System.out::println);
        Stream.of(1, 2, "a").map(item -> (item.getClass().getName())).forEach(System.out::println);
    }

    @Test
    public void iterate(){
        Stream.iterate(2, item -> item * 2).limit(10).forEach(System.out::println);
        Stream.iterate(BigInteger.ONE, n-> n.add(BigInteger.TEN)).limit(10).forEach(System.out::println);
    }

    @Test
    public void generate(){
        Stream.generate(()->"OK").limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void primitive(){
        IntStream.range(1,3).forEach(System.out::println);
        IntStream.range(0,3).mapToObj(i->"x").forEach(System.out::println);

        IntStream.rangeClosed(1,3).forEach(System.out::println);
        DoubleStream.of(1.1, 2.2, 3.3).forEach(System.out::println);

        System.out.println(IntStream.of(1,2).toArray().getClass());
        System.out.println(Stream.of(1,2).mapToInt(Integer::intValue).toArray().getClass());
        System.out.println(IntStream.of(1,2).boxed().toArray().getClass());
        System.out.println(IntStream.of(1,2).asLongStream().toArray().getClass());
        System.out.println(IntStream.of(1,2).asDoubleStream().toArray().getClass());

        Arrays.asList("a","b","c").stream()
                .mapToInt(String::length)
                .asLongStream()
                .mapToDouble(i -> i/10.0)
                .boxed()
                .mapToLong(i -> 1L)
                .mapToObj(i -> "x")
                .collect(Collectors.toList());
    }
}
