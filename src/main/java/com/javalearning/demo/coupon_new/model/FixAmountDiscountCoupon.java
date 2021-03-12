package com.javalearning.demo.coupon_new.model;

/**
 * @author lhh
 * @date 2021/3/12
 */
public class FixAmountDiscountCoupon extends AbstractUserDiscountCoupon {

    public FixAmountDiscountCoupon(UserCoupon userCoupon) {
        super(userCoupon);
    }

    @Override
    protected int discountCalculator(DiscountTarget target) {
        return 0;
    }
}
