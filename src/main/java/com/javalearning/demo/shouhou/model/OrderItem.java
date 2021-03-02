package com.javalearning.demo.shouhou.model;

import lombok.Data;

@Data
public class OrderItem {

    private Integer orderId;
    private Integer orderItemId;
    private Integer goodsId;
    private Integer specId;
    private Integer price;
    private Integer num;
}
