package com.javalearning.demo.test.strings;

import java.util.Scanner;

public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12,24,32,48,64");
        scanner.useDelimiter("\\s*,\\s*");
        while (scanner.hasNextInt()){
            System.out.println(scanner.nextInt());
        }
        System.out.println(scanner.delimiter());
    }
}
