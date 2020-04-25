package com.javalearning.demo.commonmistakes.numberalcalculation.equals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class commonmistake {

    public static void main(String[] args) {
        wrong();
        right();
        set();
    }

    private static void wrong(){
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(a.equals(b));
    }

    private static void right(){
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(a.compareTo(b) == 0);
    }

    private static void set(){
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");

        Set<BigDecimal> set1 = new HashSet<>();
        set1.add(a);
        System.out.println("hashset: " + set1.contains(b));

        Set<BigDecimal> set2 = new HashSet<>();
        set2.add(a);
        System.out.println("hashset trailing zeros: " + set2.contains(b.stripTrailingZeros()));

        Set<BigDecimal> set3 = new TreeSet<>();
        set3.add(a);
        System.out.println("treeset: " + set3.contains(b));

    }
}
