package com.javalearning.demo.commonmistakes.java8.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Order order = new Order();
        order.setAmtTotal(100);
        Optional.ofNullable(order)
                .map(Order::getAmtTotal)
                .filter(amt -> amt.equals(150))
                .orElseThrow(() -> new RuntimeException("amtTotal not equal"));
    }
}
