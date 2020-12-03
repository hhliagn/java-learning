package com.javalearning.demo.excel;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.javalearning.demo.excel.comm.ExcelTag;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming
//@ExcelTag(tag = "订单商品信息")
public class OrderItem {

    private Integer orderItemId;
    private Integer orderId;
//    @ExcelTag(tag = "订单商品Id")
    private Integer goodsId;
//    @ExcelTag(tag = "订单商品名称")
    private String goodsName;
//    @ExcelTag(tag = "订单商品价格")
    private Double goodsPrice;
//    @ExcelTag(tag = "订单商品数量")
    private Integer num;
    private Date createTime;
}
