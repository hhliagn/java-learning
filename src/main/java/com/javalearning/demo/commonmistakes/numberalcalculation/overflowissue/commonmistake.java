package com.javalearning.demo.commonmistakes.numberalcalculation.overflowissue;

import java.math.BigDecimal;
import java.math.BigInteger;

public class commonmistake {

    public static void main(String[] args) {
        wrong();
        right1();
        right2();
    }

    public static void wrong(){
        long l = Long.MAX_VALUE;
        System.out.println(l+1 == Long.MIN_VALUE);
    }

    public static void right1(){
        try {
            Long l = Long.MAX_VALUE;
            long l1 = Math.addExact(l, 1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void right2(){
        try {
            BigInteger long_max_value = new BigInteger(String.valueOf(Long.MAX_VALUE));
            BigInteger long_max_value_add_one = long_max_value.add(BigInteger.ONE);
            long l = long_max_value_add_one.longValueExact();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
