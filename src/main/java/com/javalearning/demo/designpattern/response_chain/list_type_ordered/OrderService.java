package com.javalearning.demo.designpattern.response_chain.list_type_ordered;

/**
 * @description
 * @date 2020/5/6
 */
public class OrderService {

    public Response createOrder(Object param){
        OrderCreator orderCreator = getOrderCreator(param);
        Response response = orderCreator.create();
        return response;
    }

    private OrderCreator getOrderCreator(Object param) {
        if (param.toString().equalsIgnoreCase("common")){
            return new CommonOrderCreator();
        }else {
            return new GroupOrderCreator();
        }
    }
}
