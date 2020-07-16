package com.javalearning.demo.commonmistakes.numeralcalculations.rounding;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {
        wrong();
        System.out.println();
        right();
    }

    private static void wrong(){
        double d = 3.35;
        float f = 3.35f;
        System.out.println(String.format("%.1f", d));
        System.out.println(String.format("%.1f", f));
    }

    private static void right(){
        BigDecimal bigDecimal = BigDecimal.valueOf(3.35);
        BigDecimal bigDecimal1 = bigDecimal.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(bigDecimal1.doubleValue());

        BigDecimal bigDecimal2 = bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal2.doubleValue());
    }
}

