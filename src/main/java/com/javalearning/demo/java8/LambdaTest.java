package com.javalearning.demo.java8;



import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

/**
 * @description cc
 * @date 2020/5/9
 */
public class LambdaTest {

    public void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        });

        new Thread(() -> System.out.println("hello2"));
    }

    public static void main(String[] args) {
        Supplier<String> supplier1 = String::new;
        Supplier<String> supplier2 = ()->"OK";
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());

        Predicate<Integer> predicate1 = i -> i > 0;
        Predicate<Integer> predicate2 = i -> i % 2 == 0;
        assertTrue(predicate1.and(predicate2).test(2));

        Consumer<String> consumer = System.out::println;
        consumer.andThen(consumer).accept("abcde");

        Function<String, String> function1 = s -> s.toUpperCase();
        Function<String, String> function2 = s -> s.concat(s);
        String test = function1.andThen(function2).apply("test");
        assertTrue(test.equals("TESTTEST"));

        Supplier<Integer> random = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(random.get());

        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> substract = (a,b) -> a - b;
        assertTrue(substract.apply(add.apply(1,2), 3) == 0);
    }
}
