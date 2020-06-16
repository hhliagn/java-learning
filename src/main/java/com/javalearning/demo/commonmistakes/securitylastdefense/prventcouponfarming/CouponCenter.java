package com.javalearning.demo.commonmistakes.securitylastdefense.prventcouponfarming;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CouponCenter {

    public AtomicInteger totalSent = new AtomicInteger(0);

    public void sendCounpon(Coupon coupon){
        if (coupon != null){
            totalSent.incrementAndGet();
        }
    }

    public Coupon generateCouponRight(Integer userId, CouponBatch couponBatch){
        if (couponBatch.getRemainCount().decrementAndGet() >= 0){
            return new Coupon(userId, couponBatch.getAmount());
        }

        log.info("优惠券批次 {} 优惠券不足", couponBatch.getId());
        return null;
    }

    public CouponBatch generateCouponBatch(){
        CouponBatch couponBatch = new CouponBatch();
        couponBatch.setId(1L);
        couponBatch.setTotalCount(new AtomicInteger(100));
        couponBatch.setRemainCount(couponBatch.getTotalCount());
        couponBatch.setAmount(new BigDecimal("100"));
        couponBatch.setReason("");
        return couponBatch;
    }

}
