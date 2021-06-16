package com.javalearning.demo.java8.optional.model;

import lombok.Data;

import java.util.Optional;

/**
 * @author lhh
 * @date 2021/6/16
 */
@Data
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
