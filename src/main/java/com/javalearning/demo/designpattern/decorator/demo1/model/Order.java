package com.javalearning.demo.designpattern.decorator.demo1.model;

import lombok.Data;

import java.util.Date;

/**
 * @description
 * @date 2020/5/9
 */
@Data
public class Order {

    private long orderId;
    private double amountTotal;
    private Date createTime;
    private Date updateTime;

}
