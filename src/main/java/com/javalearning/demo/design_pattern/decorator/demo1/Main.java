package com.javalearning.demo.design_pattern.decorator.demo1;

import com.javalearning.demo.design_pattern.decorator.demo1.creator.OrderCreator;
import com.javalearning.demo.design_pattern.decorator.demo1.model.Order;

/**
 * @description test main
 * @date 2020/5/9
 */
public class Main {

    public static void main(String[] args) {
        Object orderCreateParam = new Object();
        OrderCreator orderCreator = OrderFactory.getOrderCreator(orderCreateParam);
        Order order = orderCreator.create(orderCreateParam);
        System.out.println(order);
    }
}
