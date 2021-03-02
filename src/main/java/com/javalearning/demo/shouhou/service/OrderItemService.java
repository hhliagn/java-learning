package com.javalearning.demo.shouhou.service;

import com.javalearning.demo.shouhou.model.OrderItem;

public interface OrderItemService {

    OrderItem findById(Integer orderItemId);
}
