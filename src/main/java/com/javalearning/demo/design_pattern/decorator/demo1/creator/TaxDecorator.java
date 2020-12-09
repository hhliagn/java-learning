package com.javalearning.demo.design_pattern.decorator.demo1.creator;

import com.javalearning.demo.design_pattern.decorator.demo1.model.Order;

/**
 * @description
 * @date 2020/5/9
 */
public class TaxDecorator implements OrderCreator {

    private OrderCreator prevOrderCreator;

    public TaxDecorator(OrderCreator orderCreator) {
        this.prevOrderCreator = orderCreator;
    }

    @Override
    public Order create(Object orderCreateParam) {
        Order order = prevOrderCreator.create(orderCreateParam);
        System.out.println("tax decorating");
        return order;
    }
}
