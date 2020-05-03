package com.javalearning.demo.commonmistakes.numberalcalculation.dangerousDouble;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CommonMistake {

    public static void main(String[] args) {
//        wrong1();
//        testScale();
//        wrong2();
//        right();
        right2();
    }

    public static void wrong1(){
        System.out.println(0.1 + 0.2);
        System.out.println(1.0 - 0.8);
        System.out.println(4.015 * 100);
        System.out.println(123.8 / 100);

        double amount1 = 2.05;
        double amount2 = 1.0;

        if (amount1 - amount2 == 1.05){
            System.out.println("OK");
        }
    }

    public static void testScale(){

        log.info("=============raw string====");
        print(new BigDecimal("100"));
//        print(new BigDecimal("100d"));

        log.info("=============raw double====");
        print(new BigDecimal(100));
        print(new BigDecimal(100d));

        log.info("=============string value====");
        print(new BigDecimal(String.valueOf(100)));
        print(new BigDecimal(String.valueOf(100d)));

        log.info("=============double to string====");
        print(new BigDecimal(Double.toString(100)));
        print(new BigDecimal(Double.toString(100d)));

        log.info("=============value of====");
        print(BigDecimal.valueOf(100));
        print(BigDecimal.valueOf(100d));
    }

    public static void wrong2(){
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.8)));
        System.out.println(new BigDecimal(2.0).subtract(new BigDecimal(0.9)));
        System.out.println(new BigDecimal(0.3).multiply(new BigDecimal(100)));
        System.out.println(new BigDecimal(215.3).divide(new BigDecimal(2.0)));

    }

    public static void right(){
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.9")));
        System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("0.4")));
        System.out.println(new BigDecimal("4.15").multiply(new BigDecimal("100")));
        System.out.println(new BigDecimal("32.5").divide(new BigDecimal("2.0")));
    }

    public static void right2(){
        System.out.println(BigDecimal.valueOf(3.15).add(BigDecimal.valueOf(0.75)));
        System.out.println(BigDecimal.valueOf(2.0).subtract(BigDecimal.valueOf(0.5)));
        System.out.println(BigDecimal.valueOf(3.15).multiply(BigDecimal.valueOf(100)));
        System.out.println(BigDecimal.valueOf(415).divide(BigDecimal.valueOf(2.0)));
    }


    private static void print(BigDecimal bigDecimal) {
        log.info("scale {} precision {} result {}", bigDecimal.scale(), bigDecimal.precision(), bigDecimal.multiply(new BigDecimal("4.015")));
    }
}
