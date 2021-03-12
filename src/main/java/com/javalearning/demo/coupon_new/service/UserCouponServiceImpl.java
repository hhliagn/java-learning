package com.javalearning.demo.coupon_new.service;

import com.javalearning.demo.coupon_new.dto.OrderDiscountDto;
import com.javalearning.demo.coupon_new.factory.CouponFactory;
import com.javalearning.demo.coupon_new.mapper.UserCouponMapper;
import com.javalearning.demo.coupon_new.model.UserCoupon;
import com.javalearning.demo.coupon_new.model.UserDiscountCoupon;
import com.javalearning.demo.coupon_new.param.OrderDiscountParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Slf4j
@Service
public class UserCouponServiceImpl implements IUserCouponService {

    @Autowired
    private UserCouponMapper userCouponMapper;

    @Autowired
    private CouponFactory couponFactory;

    @Override
    public OrderDiscountDto calcOrderDiscount(OrderDiscountParam param) {

        Integer companyId = param.getCompanyId();
        Integer userId = param.getUserId();
        Integer userCouponId = param.getUserCouponId();

        UserCoupon userCoupon = userCouponMapper.findByComUserAndId(companyId, userId, userCouponId);

        String targetType = param.getTargetType() == null ? "goods" : param.getTargetType();
        if (!targetType.equals(userCoupon.getTargetType())) {
            return null;
        }

        if (targetType.equals("goods") && param.getItems().isEmpty()){
            return null;
        }

        UserDiscountCoupon userDiscountCoupon = couponFactory.getUserDiscountCoupon(userCoupon);


        return null;
    }
}
