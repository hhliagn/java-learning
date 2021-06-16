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
public class GraceNullAvoid {

    @Test
    public void test() {

        String carInsuranceNameV2 = getCarInsuranceNameV2(Optional.of(new Person()));
        System.out.println(carInsuranceNameV2);

    }

    public String getCarInsuranceNameV2(Optional<Person> person) {

        return person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unKnown");


    }
}
