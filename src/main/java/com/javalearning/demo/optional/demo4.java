package com.javalearning.demo.optional;

import lombok.Data;

import java.util.Optional;

public class demo4 {

    public static void main(String[] args) {
        // 优雅判空
        Order order = new Order();
        Optional.ofNullable(order)
                .map(Order::getCompanyId)
                .filter(id -> id.equals(24))
                .ifPresent(System.out::println);
    }

    @Data
    static class Order {
        private Integer companyId;
    }
}
