package com.javalearning.demo.coupon_new.model;

/**
 * @author lhh
 * @date 2021/3/12
 */
public interface DiscountTarget<T> {

    Object adaptee();
    String type();
    int amount();
    T appliedCallback(Integer amtDiscount);

    default int amtForThreshold(){
        return amount();
    }

}
