package com.javalearning.demo.coupon_new.model;

import lombok.Data;

import java.util.Date;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Data
public class Coupon {

    private Integer companyId;

    /**
     * 优惠劵ID
     */
    private Integer couponId;

    /**
     * 优惠劵名称
     */
    private String couponName;

    /**
     * 优惠对象，goods,logistics
     */
    private String targetType;

    /**
     * 计算 amount，ratio
     */
    private String discountType;

    /**
     * 减免金额，单位分
     */
    private Integer amtCouponDiscount;

    private Double ratioDiscount;

    /**
     * 可用额度，带额度可以多次使用
     */
    private Integer amtQuota;

    /**
     * 优惠券发放总量
     */
    private Integer totalCouponIssue;

    /**
     * 使用门槛类型,1-无门槛，2-满x元
     */
    private String  couponLimitType;

    /**
     * 门槛金额(满x元使用)
     */
    private Integer amtCouponLimit;

    /**
     * 适用商品类型,1-全部商品可用，2-指定商品可用，3-指定商品不可用, 4-指定商品品类可用，5-指定商品品类不可用
     */
    private String  suitGoodsType;

    /**
     * 1全部地区可用， 2指定地区可用， 3指定地区不可用
     */
    private Integer suitAreaType;

    /**
     * 地区
     */
    private String area;

    /**
     * 优惠劵有效期类型,1-有具体时间范围，2-自用户领券后几天内有效
     */
    private String  couponExpireType;

    /**
     * 优惠劵有效期开始时间
     */
    private Integer tStartCouponExpire;

    /**
     * 优惠劵有效期结束时间
     */
    private Integer tEndCouponExpire;

    /**
     * 优惠劵有效期天数
     */
    private Integer nDayCouponExpire;

    /**
     * 优惠叠加，0-可叠加使用，1-不可叠加使用(秒杀，拼团等商品不可用)
     */
    private Integer isOfferOverlay;

    /**
     * 是否可主动领取，1-不可主动领取，2-可主动领取
     */
    private Integer receiveType;

    /**
     * 领取人限制，1-所有人（普通会员），2-vip会员，3 -身份 新用户（0）、老用户（1），4 - 等级
     */
    private Integer receiveVipLimit;

    /**
     * 领取人限制 值
     */
    private String receiveLimitVal;

    /**
     * 领取次数类型，1-总共可领取x次，2-每x天可领取1次
     */
    private String nReceiveType;

    /**
     * 总共可领取x次
     */
    private Integer nReceive;

    /**
     * 每x天可领取1次
     */
    private Integer nDayReceive;

    /**
     * 使用说明
     */
    private String remark;

    /**
     * 优惠劵状态，1-新建，2-进行中，3-中止发劵，4-优惠劵已发完，5-优惠劵已过期，6-活动结束
     */
    private Integer state;

    /**
     * 优惠劵 定时上架时间戳
     */
    private Integer timedPub;

    /** 该字段存着所有的一级分类id，为空则都所有一级分类都可以用 */
    private String catParentId;

    /**
     * 创建人
     */
    private String createdBy;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;
}
