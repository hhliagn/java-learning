package com.javalearning.demo.coupon_new.model;

import lombok.Data;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Data
public class CouponDescription {

    /**
     * 优惠券类型 goods, logistics
     */
    private String type;

    /**
     * 类型名称 商品券，运费券
     */
    private String typeName;

    /**
     * 面值
     */
    private String value;

    /**
     * 面值前缀
     */
    private String prefix;

    /**
     * 面值后缀
     */
    private String suffix;

    /**
     * 有效时间
     */
    private String validTime;

    /**
     * 门槛描述
     */
    private String threshold = "无门槛使用";

    /**
     * 详细说明
     */
    private String detail;
}
