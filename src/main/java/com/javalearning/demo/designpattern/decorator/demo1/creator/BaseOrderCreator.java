package com.javalearning.demo.designpattern.decorator.demo1.creator;

import com.javalearning.demo.designpattern.decorator.demo1.model.Order;

/**
 * @description 基础订单创建器
 * @date 2020/5/9
 */
public class BaseOrderCreator implements OrderCreator{

    @Override
    public Order create(Object orderCreateParams) {
        System.out.println("BaseOrderCreator handle");
        return new Order();
    }
}
