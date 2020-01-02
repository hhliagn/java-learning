package com.javalearning.demo.test.adapter1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdapterRandomDoubles(7));
        while (scanner.hasNextDouble()){
            System.out.println(scanner.nextDouble() + " ");
        }
    }
}
