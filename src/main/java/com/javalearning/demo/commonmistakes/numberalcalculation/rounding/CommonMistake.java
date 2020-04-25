package com.javalearning.demo.commonmistakes.numberalcalculation.rounding;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CommonMistake {

    public static void main(String[] args) {
//        wrong1();
//        wrong2();
        right();
    }

    private static void wrong1(){
        double num1 = 3.35;
        float num2 = 3.35f;
        System.out.println(String.format("%.1f", num1));
        System.out.print(String.format("%.1f", num2));
    }

    private static void wrong2(){
        double num1 = 3.35;
        float num2 = 3.35f;

        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.DOWN);
        System.out.println(format.format(num1));
        System.out.println(format.format(num2));
    }

    private static void right(){
        BigDecimal num1 = new BigDecimal("3.35");

        BigDecimal down = num1.setScale(1, RoundingMode.DOWN);
        System.out.println(num1 + " down " + down);

        BigDecimal half_up = num1.setScale(1, RoundingMode.HALF_UP);
        System.out.println(num1 + " half up " + half_up);
    }
}
