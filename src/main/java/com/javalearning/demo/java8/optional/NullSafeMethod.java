package com.javalearning.demo.java8.optional;

import com.javalearning.demo.java8.optional.model.Car;
import com.javalearning.demo.java8.optional.model.Insurance;
import com.javalearning.demo.java8.optional.model.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class NullSafeMethod {

    @Test
    public void test() {

        Optional<Insurance> insurance = nullSafeFindCheapestInsurance(Optional.of(new Person()), Optional.of(new Car()));
        insurance.orElseThrow(() -> new RuntimeException("No such Insurance"));

    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));

    }

    private Insurance findCheapestInsurance(Person p, Car c) {
        return null;
    }
}
