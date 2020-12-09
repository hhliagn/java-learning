package com.javalearning.demo.design_pattern.strategy.demo1;

import java.util.Scanner;

public class Main {

    private static AlgsStrategy strategy;

    public static void main(String[] args) {

        int a = 10, b = 5;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();

            if ("add".equals(line)){
                strategy = new Add();
            }

            if ("sub".equals(line)){
                strategy = new Sub();
            }

            int ret = strategy.algs(a, b);
            System.out.println(ret);
        }
    }
}
