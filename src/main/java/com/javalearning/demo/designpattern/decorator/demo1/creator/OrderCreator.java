package com.javalearning.demo.designpattern.decorator.demo1.creator;

import com.javalearning.demo.designpattern.decorator.demo1.model.Order;

/**
 * @description 订单创建器
 * @date 2020/5/9
 */
public interface OrderCreator{

    Order create(Object orderCreateParam);
}
