package com.javalearning.demo.coupon_new.service;

import com.javalearning.demo.coupon_new.dto.OrderDiscountDto;
import com.javalearning.demo.coupon_new.param.OrderDiscountParam;

/**
 * @author lhh
 * @date 2021/3/12
 */
public interface IUserCouponService {

    OrderDiscountDto calcOrderDiscount(OrderDiscountParam param);
}
