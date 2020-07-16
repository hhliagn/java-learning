package com.javalearning.demo.commonmistakes.numeralcalculations.overflowissue;

import java.math.BigInteger;

public class CommonMistakesApplication {

    public static void main(String[] args) {
        wrong();
        right1();
        right2();
    }

    private static void wrong(){
        long l = Long.MAX_VALUE;
        long l1 = l + 1;
        System.out.println(l1);
    }

    private static void right1(){
        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(bigInteger.add(BigInteger.ONE).toString());

        try {
            bigInteger.add(BigInteger.ONE).longValueExact();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void right2(){
        long l = Long.MAX_VALUE;
        try {
            long l1 = Math.addExact(l, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

