package com.javalearning.demo.coupon_new.model;

import lombok.Data;

import java.util.Date;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Data
public class UserCoupon {

    private Integer id;

    /**
     * 企业ID
     */
    private Integer companyId;

    /**
     * 用户ID
     */
    private Integer userId;


    /**
     * 预发放ID
     */
    private String preIssueId;

    /**
     * 优惠劵ID
     */
    private Integer couponId;

    /**
     * 优惠劵名称
     */
    private String name;

    /**
     * 优惠对象，goods,logistics
     */
    private String targetType;

    /**
     * 门槛，无门槛则为0
     */
    private Integer amtThreshold;

    /**
     * 优惠计算方式, amount固定金额，ratio固定比例
     */
    private String discountType;

    private Integer amtDiscount;

    private Double ratioDiscount;

    /**
     * 起始额度
     */
    private Integer amtQuota;

    /**
     * 已用额度
     */
    private Integer amtUsed;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 优惠劵过期开始时间
     */
    private Integer tStartExpire;

    /**
     * 优惠劵过期结束时间
     */
    private Integer tEndExpire;

    /**
     * 用户使用优惠劵时间
     */
    private Integer tUsed;

    /**
     * 领取类型 0-平台发放， 1-主动领取
     */
    private String receiveType;

    /**
     * 自动发放类型
     */
    private String issueType;

    /**
     * 用户优惠劵状态，0-可使用, 1-已过期，2-已使用，3-使用中，4-预发放， 10-订单不可用
     */
    private Integer state;

    private Coupon coupon;

    private Integer version;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;
}
