package com.javalearning.demo.coupon;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.javalearning.demo.coupon.model.CouponBatch;
import com.javalearning.demo.coupon.model.CouponUser;
import com.javalearning.demo.coupon.service.CouponBatchService;
import com.javalearning.demo.coupon.service.CouponUserService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponCenter {

    @Autowired
    private CouponBatchService couponBatchService;

    @Autowired
    private CouponUserService couponUserService;

    @Autowired
    private RedissonClient redissonClient;

    public void applyCoupon(){
        CouponBatch couponBatch = new CouponBatch();
        couponBatch.setCouponId(123);
        couponBatch.setAmount(100);
        couponBatch.setReason("蝴蝶猫发券");
        couponBatch.setApplyTime(new Date());
        int row = couponBatchService.save(couponBatch);
    }

    public void issueCoupon(Integer couponId, Integer userId, Integer couponBatchId) throws InterruptedException {
        RLock lock = redissonClient.getLock("lock");
        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
            try {
                CouponBatch couponBatch = couponBatchService.findById(couponBatchId);
                Integer remain = couponBatch.getRemain();
                AtomicInteger atomicRemain = new AtomicInteger(remain);
                if (atomicRemain.decrementAndGet() >= 0){
                    CouponUser couponUser = new CouponUser();
                    couponUser.setUserId(userId);
                    couponUser.setCouponId(couponId);
                    couponUser.setIssueTime(new Date());
                    couponUser.setState(1);
                    int row = couponUserService.save(couponUser);
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
