package com.javalearning.demo.stream.anymatch;

import lombok.Data;

@Data
public class OrderItem {

    /**
     * 是否赠品  -0 非赠品 -1 赠品
     */
    private Integer ifPresent;
}
