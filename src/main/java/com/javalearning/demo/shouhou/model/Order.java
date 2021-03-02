package com.javalearning.demo.shouhou.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Integer companyId;
    private Integer orderId;
    private String orderNo;
    private Integer userId;
    private List<OrderItem> items;
    private Long amt;
    private Date create_time;
}
