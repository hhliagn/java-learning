package com.javalearning.demo.coupon_new.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Data
@JsonNaming
public class OrderDiscountDto {

    private Integer companyId;
    private Integer userId;
    private Integer couponId;
    private Integer userCouponId;
    private String targetType;
    private Long txId;
    private int totalDiscount;
    private int amtLogisticsDiscount;
    private List<Item> items;

    public OrderDiscountDto() {
        this.userCouponId = 0;
        this.totalDiscount = 0;
        this.amtLogisticsDiscount = 0;
    }

    @Data
    @JsonNaming
    class Item {

        private Integer shopId;
        private Integer goodsId;
        private Integer specId;
        private Integer totalPrice;
        private Integer num;
        private Integer userCouponId;
        private Integer amtDiscount;
    }
}
