package com.javalearning.demo.coupon_new.model;

/**
 * @author lhh
 * @date 2021/3/12
 */
public interface UserDiscountCoupon extends DiscountCoupon{

    UserCoupon userCoupon();

    <T extends DiscountResult<T>> T previewFor(DiscountTarget< T> target);

    <T extends DiscountResult<T>> T applyTo(DiscountTarget<T> target);
}
