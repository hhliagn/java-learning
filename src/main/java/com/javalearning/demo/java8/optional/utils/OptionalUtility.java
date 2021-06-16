package com.javalearning.demo.java8.optional.utils;

import java.util.Optional;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class OptionalUtility {

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
