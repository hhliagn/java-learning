package com.javalearning.demo.designpattern.decorator.demo1;

import com.javalearning.demo.designpattern.decorator.demo1.creator.*;

/**
 * @description 订单工厂
 * @date 2020/5/9
 */
public class OrderFactory {

    public static OrderCreator getOrderCreator(Object orderCreateParams){
        OrderCreator orderCreator = new BaseOrderCreator();

        if (orderCreateParams instanceof Object){
            orderCreator = new AgentDecorator(orderCreator);
        }

        orderCreator = new TaxDecorator(orderCreator);
        orderCreator = new LogisticsDecorator(orderCreator);

        return orderCreator;
    }
}
