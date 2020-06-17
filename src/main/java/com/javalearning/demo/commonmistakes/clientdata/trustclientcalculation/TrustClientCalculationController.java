package com.javalearning.demo.commonmistakes.clientdata.trustclientcalculation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RequestMapping("trustclientcalculation")
@RestController
public class TrustClientCalculationController {
    @PostMapping("/order")
    public void wrong(@RequestBody Order order) {
        this.createOrder(order);
    }

    @PostMapping("/orderRight")
    public void right(@RequestBody Order order) {
        Item item = Db.getItem(order.getItemId());
        if (item.getItemPrice().equals(order.getItemPrice())){
            throw new RuntimeException("您选购的商品价格有变化，请重新下单");
        }

        order.setItemPrice(item.getItemPrice());
        order.setTotalPrice(order.getItemPrice().multiply(new BigDecimal(order.getQuantity())));
        createOrder(order);
    }

    @PostMapping("orderRight2")
    public Order right2(@RequestBody CreateOrderRequest createOrderRequest) {
        long itemId = createOrderRequest.getItemId();
        Item item = Db.getItem(itemId);
        Order order = new Order();
        order.setItemPrice(item.getItemPrice());
        order.setTotalPrice(item.getItemPrice().multiply(BigDecimal.valueOf(createOrderRequest.getQuantity())));
        createOrder(order);
        return order;
    }

    private void createOrder(Order order) {

    }
}
