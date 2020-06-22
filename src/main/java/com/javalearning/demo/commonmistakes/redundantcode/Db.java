package com.javalearning.demo.commonmistakes.redundantcode;

import java.math.BigDecimal;

public class Db {

    public static BigDecimal getItemPrice(Long itemId){
        return BigDecimal.ZERO;
    }
}
