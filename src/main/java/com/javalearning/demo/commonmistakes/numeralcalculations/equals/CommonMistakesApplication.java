package com.javalearning.demo.commonmistakes.numeralcalculations.equals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CommonMistakesApplication {

    public static void main(String[] args) {
        wrong();
        right();
        set();
    }

    private static void wrong(){
        BigDecimal bigDecimal = BigDecimal.valueOf(1);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(1.0);
        System.out.println(bigDecimal.equals(bigDecimal1));
    }

    private static void right(){
        BigDecimal bigDecimal = BigDecimal.valueOf(1);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(1.0);
        System.out.println(bigDecimal.compareTo(bigDecimal1));
        System.out.println();
    }

    private static void set(){
        Set<BigDecimal> set1 = new HashSet<>();
        BigDecimal bigDecimal = BigDecimal.valueOf(1.0);
        set1.add(bigDecimal);
        System.out.println(set1.contains(BigDecimal.valueOf(1)));

        System.out.println();

        Set<BigDecimal> set2 = new TreeSet<>();
        BigDecimal bigDecimal2 = BigDecimal.valueOf(1);
        set2.add(bigDecimal2);
        System.out.println(set2.contains(BigDecimal.valueOf(1.0)));

    }
}

