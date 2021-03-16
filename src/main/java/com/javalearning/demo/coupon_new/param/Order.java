package com.javalearning.demo.coupon_new.param;

import java.util.List;

/**
 * @author lhh
 * @date 2021/3/12
 */
public interface Order {

    Integer getProvinceId();

    default Integer getAmtTotal(){
        return getAmtGoods() + getAmtLogistics();
    }

    default Integer getAmtGoods(){
        int sum = 0;
        for (OrderItem item : getItems()) {
            sum += item.getTotalPrice();
        }

        return sum;
    }

    Integer getAmtLogistics();

    List<OrderItem> getItems ();

    interface OrderItem {

        Integer getShopId();
        Integer getGoodsId();
        Integer getSpecId();
        Integer getCatId();
        Integer getTotalPrice();
        Integer getNum();
    }

}
