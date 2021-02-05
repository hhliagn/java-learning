package com.javalearning.demo.operate_log.anno;


public enum OperateType {
    LOGIN("登录"),
    ORDER_ADD("下单"),
    GET_ORDER_LIST("获取订单列表，ids={}"),
    ORDER_DELIVER("订单发货，orderNo={}"),
    ORDER_IMPORT("导入订单，文件名={}"),
    ;

    private String ext;
    OperateType(String ext) {
        this.ext = ext;
    }

    public String getExt() {
        return ext;
    }
}
