package com.javalearning.demo.design_pattern.decorator.demo2.component;

/**
 * @description 订单处理器
 * @date 2020/5/9
 */
public interface OrderProcessor {

    Order create();
    Order pay(Order order);
    Order refund(Order order);
}
