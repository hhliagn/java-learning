package com.javalearning.demo.designpattern.decorator.demo1.creator;


import com.javalearning.demo.designpattern.decorator.demo1.model.Order;

/**
 * @description
 * @date 2020/5/9
 */
public class AgentDecorator implements OrderCreator {

    private OrderCreator prevOrderCreator;

    public AgentDecorator(OrderCreator orderCreator) {
        this.prevOrderCreator = orderCreator;
    }

    @Override
    public Order create(Object orderCreateParam) {
        Order order = prevOrderCreator.create(orderCreateParam);
        System.out.println("AgentDecorator handling");
        return order;
    }
}
