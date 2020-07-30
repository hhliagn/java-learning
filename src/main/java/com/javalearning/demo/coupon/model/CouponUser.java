package com.javalearning.demo.coupon.model;

import lombok.Data;

import java.util.Date;

@Data
public class CouponUser {
    private Integer id;
    private Integer userId;
    private Integer couponId;
    private Date issueTime;
    private Integer state;
}
