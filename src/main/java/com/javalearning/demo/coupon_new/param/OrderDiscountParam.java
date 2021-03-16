package com.javalearning.demo.coupon_new.param;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhh
 * @date 2021/3/12
 */
@Data
@JsonNaming
public class OrderDiscountParam implements Order {

    @NotNull(message = "缺少companyId")
    private Integer companyId;

    @NotNull(message = "缺少userId")
    private Integer userId;

    @NotNull(message = "缺少优惠券id")
    private Integer userCouponId;

    private String targetType;
    private String orderNo;
    private Integer amtLogistics;
    private Integer provinceId;
    private List<Item> items;
    private boolean preview;

    @Override
    public List<OrderItem> getItems(){
        return new ArrayList<>();
    }

    @Data
    @JsonNaming
    class Item implements OrderItem {

        @NotNull(message = "缺少shopId")
        private Integer shopId;

        @NotNull(message = "缺少goodsId")
        private Integer goodsId;
        @NotNull(message = "缺少specId")
        private Integer specId;

        @NotNull(message = "缺少catId")
        private Integer catId;

        @NotNull(message = "缺少购买数量num")
        private Integer num;

        @NotNull(message = "缺少总价")
        private Integer totalPrice;

        private String otherDiscount;
        private boolean inActivity;
    }
}
