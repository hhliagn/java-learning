package com.javalearning.demo.designpattern.response_chain.wrong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description
 * @date 2020/5/6
 */
public class OrderService {


    public Response createOrder(Object createOrderParams){

        OrderChain orderChain = new OrderChain();
        //普通订单：1.验证参数 2.状态设置 3.入库 4.后续消息通知
        orderChain.excute();

        //拼团订单：1.验证参数 2.拼团检查（包含优惠计算） 3.状态设置 4.入库 5.后续消息通知
        orderChain.add(StrategyEnum.GROUPING_CHECK);
        orderChain.excute();

        //移仓订单：1.验证参数 2.上级审核 3.状态设置 4.入库 5.后续消息通知

        return null;
    }

    public static void main(String[] args) {
        //测试Enum排序
        List<StrategyEnum> enums = new ArrayList<>();
        enums.add(StrategyEnum.PERSIST);
        enums.add(StrategyEnum.PARAM_CHECK);
        enums.add(StrategyEnum.STATE_SET);
        enums.add(StrategyEnum.GROUPING_CHECK);
        enums.add(StrategyEnum.PERSIST);

        Collections.sort(enums);

        enums.forEach(s -> System.out.println(s.name()));
    }
}
