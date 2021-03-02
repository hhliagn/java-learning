package com.javalearning.demo.shouhou.service;

import com.javalearning.demo.shouhou.model.Order;

public interface OrderService {

    Order findByOrderNo(String orderNo);
}
