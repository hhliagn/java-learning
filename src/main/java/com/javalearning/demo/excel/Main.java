package com.javalearning.demo.excel;

import com.javalearning.demo.excel.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<OrderInfo> orderInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Date createTime = new Date();

            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderId(i);
            orderInfo.setCompanyId(24);
            orderInfo.setOrderType("common");
            orderInfo.setOrderState(2);
            orderInfo.setOrderUserId(11303);
            orderInfo.setOrderUserName("梁恒辉");
            orderInfo.setOrderUserPhone("13546995851");
            orderInfo.setReceiveUserId(11528);
            orderInfo.setReceiveUserName("zzz");
            orderInfo.setReceiveUserPhone("13800138000");
            orderInfo.setAmtTotal(99.9);
            orderInfo.setCreateTime(createTime);

            List<OrderItem> items = new ArrayList<>();
            for (int i1 = 0; i1 < 2; i1++) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemId(i1);
                orderItem.setOrderId(i);
                orderItem.setGoodsId(480009);
                orderItem.setGoodsName("9.9疯抢套装A");
                orderItem.setGoodsPrice(9.9);
                orderItem.setNum(10);
                orderItem.setCreateTime(createTime);
                items.add(orderItem);
            }

            orderInfo.setItems(items);

            orderInfos.add(orderInfo);
        }

        Workbook wb = ExcelUtil.export(orderInfos, OrderInfo.class, false);
        ExcelUtil.exportToLocal(wb, "导出test.xlsx");
        System.out.println("Done!");
    }
}
