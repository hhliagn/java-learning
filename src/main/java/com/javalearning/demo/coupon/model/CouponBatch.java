package com.javalearning.demo.coupon.model;

import lombok.Data;

import java.util.Date;

@Data
public class CouponBatch {
    private Integer id;
    private Integer couponId;
    private Integer amount;
    private Integer remain;
    private String reason;
    private Date applyTime;
}
