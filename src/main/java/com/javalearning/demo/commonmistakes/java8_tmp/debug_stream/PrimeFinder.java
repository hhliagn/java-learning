package com.javalearning.demo.commonmistakes.java8_tmp.debug_stream;

import java.util.stream.IntStream;

public class PrimeFinder {
    public static void main(String[] args) { // not work
        IntStream.iterate(1, n -> n + 1)
                .skip(Integer.parseInt(args[0]))
                .limit(Integer.parseInt(args[1]))
                .filter(PrimeFinder::isPrime)
                .forEach(System.out::println);
    }

    private static boolean isPrime(int i) {
        if (i == 1 || i == 2 || i == 3){
            return true;
        }
        if (i / i == 1) {
            return true;
        }
        return false;
    }
}
