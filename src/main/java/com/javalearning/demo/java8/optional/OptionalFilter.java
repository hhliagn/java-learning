package com.javalearning.demo.java8.optional;

import com.javalearning.demo.java8.optional.model.Insurance;
import org.junit.Test;

import java.util.Optional;

/**
 * @author lhh
 * @date 2021/6/16
 */
public class OptionalFilter {


    @Test
    public void test() {

        checkInsuranceName(Optional.of(new Insurance()));
    }

    private void checkInsuranceName(Optional<Insurance> optInsurance) {

        optInsurance
                .filter(insurance -> "CambridgeInsurance".equals(insurance.getName()))
                .ifPresent(x -> System.out.println("ok"));


    }


}
