package com.javalearning.demo.commonmistakes.numeralcalculations.dangerousdouble;


import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CommonMistakesApplication {

    public static void main(String[] args) {
        wrong();
        System.out.println();
        wrong2();
        System.out.println();
        right();
    }

    private static void wrong(){
        System.out.println(0.1 + 0.2);
        System.out.println(1.0 - 0.8);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
    }

    private static void wrong2(){
        BigDecimal bigDecimal1 = new BigDecimal(0.1).add(new BigDecimal(0.2));
        BigDecimal bigDecimal2 = new BigDecimal(1.0).subtract(new BigDecimal(0.8));
        BigDecimal bigDecimal3 = new BigDecimal(4.015).multiply(new BigDecimal(100));
        BigDecimal bigDecimal4 = new BigDecimal(123.3).divide(new BigDecimal(100));
        System.out.println(bigDecimal1.doubleValue());
        System.out.println(bigDecimal2.doubleValue());
        System.out.println(bigDecimal3.doubleValue());
        System.out.println(bigDecimal4.doubleValue());
    }

    private static void right(){
        BigDecimal bigDecimal1 = new BigDecimal("0.1").add(new BigDecimal("0.2"));
        BigDecimal bigDecimal2 = new BigDecimal("1.0").subtract(new BigDecimal("0.8"));
        BigDecimal bigDecimal3 = new BigDecimal("4.015").multiply(new BigDecimal("100"));
        BigDecimal bigDecimal4 = new BigDecimal("123.3").divide(new BigDecimal("100"));
        System.out.println(bigDecimal1.doubleValue());
        System.out.println(bigDecimal2.doubleValue());
        System.out.println(bigDecimal3.doubleValue());
        System.out.println(bigDecimal4.doubleValue());
    }

}

