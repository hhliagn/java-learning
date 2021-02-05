package com.javalearning.demo.operate_log.param;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming
public class AddOrderParam {
    private String goodsName;
    private String supplierName;
    private String userId;
}
