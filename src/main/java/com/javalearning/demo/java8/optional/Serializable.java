package com.javalearning.demo.java8.optional;

import com.javalearning.demo.java8.optional.model.Car;
import lombok.Data;

import java.util.Optional;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class Serializable {

    public static void main(String[] args) {

        Person person = new Person();

        Optional<Car> optCar = person.getCarAsOptional();

        Car car = optCar.orElse(null);

        System.out.println(car);

    }
}

@Data
class Person {

    private Car car;

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}
