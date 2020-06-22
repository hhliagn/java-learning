package com.javalearning.demo.commonmistakes.redundantcode.templatemethod;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Cart {

    private List<Item> items;

    private BigDecimal totalItemPrice;

    private BigDecimal totalDiscount;

    private BigDecimal totalDeliveryPrice;

    private BigDecimal payPrice;
}
