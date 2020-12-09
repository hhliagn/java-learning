package com.javalearning.demo.design_pattern.decorator.demo2.component;

/**
 * @description 普通订单处理器
 * @date 2020/5/9
 */
public class CrowdOrderProcessor implements OrderProcessor{


    @Override
    public Order create() {
        Order order = new Order();
        System.out.println("CrowdOrderProcessor create");
        return order;
    }

    @Override
    public Order pay(Order order) {
        System.out.println("CrowdOrderProcessor pay");
        return order;
    }

    @Override
    public Order refund(Order order) {
        System.out.println("CrowdOrderProcessor refund");
        return order;
    }
}
