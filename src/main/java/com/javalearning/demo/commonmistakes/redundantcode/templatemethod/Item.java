package com.javalearning.demo.commonmistakes.redundantcode.templatemethod;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

    private long id;

    private int quantity;

    private BigDecimal price;

    private BigDecimal deliveryPrice;

    private BigDecimal couponPrice;
}
