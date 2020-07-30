package com.javalearning.demo.coupon.model;

import lombok.Data;

@Data
public class Coupon {
    private Integer id;
    private Long price;
    private String title;
    private String desc;
}
