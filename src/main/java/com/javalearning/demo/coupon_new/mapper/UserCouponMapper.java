package com.javalearning.demo.coupon_new.mapper;

import com.javalearning.demo.coupon_new.model.UserCoupon;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Mapper
public interface UserCouponMapper {

    UserCoupon findByComUserAndId(Integer companyId, Integer userId, Integer userCouponId);
}
