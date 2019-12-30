package com.javalearning.demo.test.enum1;

public class EnumOrder {
    public static void main(String[] args) {
        for (Color value : Color.values()) {
            System.out.println(value + ",ordinal: " + value.ordinal());
        }
    }
}
