package com.javalearning.demo.shouhou.controller;

import com.javalearning.demo.shouhou.common.Response;
import com.javalearning.demo.shouhou.common.req.ShouhouApplyReq;
import com.javalearning.demo.shouhou.model.Order;
import com.javalearning.demo.shouhou.model.OrderItem;
import com.javalearning.demo.shouhou.service.OrderItemService;
import com.javalearning.demo.shouhou.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shouhou")
public class ShouHouController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/apply")
    public Response apply(ShouhouApplyReq req){

        log.info("shouhou apply req: {}", req);

        String orderNo = req.getOrderNo();
        Order order = orderService.findByOrderNo(orderNo);

        List<ShouhouApplyReq.ApplyItem> items = req.getItems();
        if (CollectionUtils.isEmpty(items)){
            return Response.fail();
        }

        Long total = 0L;
        for (ShouhouApplyReq.ApplyItem item : items) {
            Integer orderItemId = item.getOrderItemId();
            OrderItem orderItem = orderItemService.findById(orderItemId);

            total += (orderItem.getPrice() * item.getNum());
        }

        if (total > order.getAmt()){
            return Response.fail();
        }

        if (!total.equals(req.getAmt())){
            return Response.fail();
        }



        return Response.success();
    }
}
