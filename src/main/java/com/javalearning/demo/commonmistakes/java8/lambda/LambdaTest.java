package com.javalearning.demo.commonmistakes.java8.lambda;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LambdaTest {

    @Test
    public void lambdavsanonymousclass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }).start();

        new Thread(() -> System.out.println("hello2")).start();
    }

    @Test
    public void functionalInterfaces() {
        //可以看一下java.util.function包
        Supplier<String> supplier = String::new;
        Supplier<String> stringSupplier = () -> "OK";

        //Predicate的例子
        Predicate<Integer> positiveNumber = i -> i > 0;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        assertTrue(positiveNumber.and(evenNumber).test(2));

        //Consumer的例子，输出两行abcdefg
        Consumer<String> println = System.out::println;
        println.andThen(println).accept("abcdefg");

        //Function的例子
        Function<String, String> upperCase = String::toUpperCase;
        Function<String, String> duplicate = s -> s.concat(s);
        assertThat(upperCase.andThen(duplicate).apply("test"), is("TESTTEST"));

        //Supplier的例子
        Supplier<Integer> random = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(random.get());

        //BinaryOperator
        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> subtraction = (a, b) -> a - b;
        assertThat(subtraction.apply(add.apply(1, 2), 3), is(0));
    }

    @Test
    public void functionalInterface(){
        Supplier<String> supplier1 = () -> "OK";
        Supplier<String> supplier2 = String::new;

        Predicate<Integer> predicate = i -> i > 0;
        Predicate<Integer> predicate1 = i -> i % 2 == 0;
        assertTrue(predicate.and(predicate1).test(2));

        Function<String, String> function = String::toUpperCase;
        Function<String, String> function1 = s -> s.concat(s);
        assertEquals("TEXTTEXT", function.andThen(function1).apply("text"));

        Consumer<String> println = System.out::println;
        println.andThen(println).accept("abcde");

        Supplier<Integer> supplier = () -> ThreadLocalRandom.current().nextInt();
        Integer random = supplier.get();
        System.out.println(random);

        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> substract = (a, b) -> a - b;
        assertThat(substract.apply(add.apply(1,2), 3), is(0));
    }
}
