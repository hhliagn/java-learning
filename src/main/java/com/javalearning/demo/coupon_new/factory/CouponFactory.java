package com.javalearning.demo.coupon_new.factory;

import com.javalearning.demo.coupon_new.mapper.CouponGoodsMapper;
import com.javalearning.demo.coupon_new.model.FixAmountDiscountCoupon;
import com.javalearning.demo.coupon_new.model.UserCoupon;
import com.javalearning.demo.coupon_new.model.UserDiscountCoupon;
import com.javalearning.demo.coupon_new.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Component
public class CouponFactory {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private CouponGoodsMapper couponGoodsMapper;

    public UserDiscountCoupon getUserDiscountCoupon(UserCoupon userCoupon){

        UserDiscountCoupon res;

        if ("amount".equals(userCoupon.getDiscountType())) {
            res = new FixAmountDiscountCoupon(userCoupon);
        }

        return null;
    }




}
