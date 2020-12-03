package com.javalearning.demo.excel;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.javalearning.demo.excel.comm.ExcelTag;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Data
@JsonNaming
@ExcelTag(tag = "订单信息")
public class OrderInfo {

    @ExcelTag(tag = "订单Id")
    private Integer orderId;
    @ExcelTag(tag = "公司Id")
    private Integer companyId;
    @ExcelTag(tag = "订单类型")
    private String orderType;
    @ExcelTag(tag = "订单状态")
    private Integer orderState;

    private Integer orderUserId;

    @ExcelTag(tag = "下单人姓名")
    private String orderUserName;
    @ExcelTag(tag = "下单人手机号")
    private String orderUserPhone;

    private Integer receiveUserId;

    @ExcelTag(tag = "收货人姓名")
    private String receiveUserName;
    @ExcelTag(tag = "收货人手机号")
    private String receiveUserPhone;
    @ExcelTag(tag = "订单总额")
    private Double amtTotal;
    @ExcelTag(tag = "创建时间")
    private Date createTime;
    @ExcelTag(tag = "订单item")
    private List<OrderItem> items;

//    public String getCreateTime() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//        return simpleDateFormat.format(createTime);
//    }
//
//    public String getItems() {
//        if (CollectionUtils.isEmpty(items)){
//            return "";
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (OrderItem item : items) {
//            stringBuilder.append("[");
//            stringBuilder.append(item.getGoodsName());
//            stringBuilder.append(",");
//            stringBuilder.append(item.getGoodsPrice());
//            stringBuilder.append(",");
//            stringBuilder.append(item.getNum());
//            stringBuilder.append("]");
//            stringBuilder.append(",");
//        }
//
//        stringBuilder.substring(0, stringBuilder.length() - 1);
//        return stringBuilder.toString();
//    }
}
