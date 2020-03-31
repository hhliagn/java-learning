package com.javalearning.demo.lambda;

import java.util.Arrays;
import java.util.List;

public class demo5 {

    // map(数据处理，一个参数) 和 reduce(累加，两个参数)
    public static void main(String[] args) {
        List<Double> costBeforeTax = Arrays.asList(100.0, 200.0, 300.0, 400.0, 500.0);
        double total1 = 0;
        for (Double beforeTax : costBeforeTax) {
            beforeTax += beforeTax * 0.12;
            total1 += beforeTax;
            System.out.print(beforeTax + " ");
        }
        System.out.println();
        System.out.println(total1);

        System.out.println("=====================");

        double total2 = 0;
        costBeforeTax.stream().map( cost -> cost += cost * 0.12).forEach( aftercost -> System.out.print(aftercost + " "));
        total2 = costBeforeTax.stream().map(cost -> cost += cost * 0.12).reduce((sum, cost) -> sum += cost).get();
        System.out.println();
        System.out.println(total2);
    }
}
