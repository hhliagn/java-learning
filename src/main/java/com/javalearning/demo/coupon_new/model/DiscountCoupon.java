package com.javalearning.demo.coupon_new.model;

/**
 * @author lhh
 * @date 2021/3/12
 */
public interface DiscountCoupon {

    Integer companyId();
    Integer tplId();
    String name();
    String targetType();
    Integer state();
    boolean available();
    boolean availableFor(DiscountTarget target);
    int calacAmtDiscountFor(DiscountTarget target);
    Integer amtAvailable();
    CouponDescription getDescription();
}
