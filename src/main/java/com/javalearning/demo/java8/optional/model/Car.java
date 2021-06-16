package com.javalearning.demo.java8.optional.model;

import lombok.Data;

import java.util.Optional;

/**
 * @author lhh
 * @date 2021/6/16
 */
@Data
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
