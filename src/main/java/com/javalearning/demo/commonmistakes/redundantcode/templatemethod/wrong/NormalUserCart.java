package com.javalearning.demo.commonmistakes.redundantcode.templatemethod.wrong;

import com.javalearning.demo.commonmistakes.redundantcode.Db;
import com.javalearning.demo.commonmistakes.redundantcode.templatemethod.Cart;
import com.javalearning.demo.commonmistakes.redundantcode.templatemethod.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NormalUserCart {
    public Cart process(Long userId, Map<Long,Integer> map){
        Cart cart = new Cart();
        List<Item> items = new ArrayList<>();
        map.entrySet().stream().forEach(entry -> {

            Long itemId = entry.getKey();
            Integer quantity = entry.getValue();

            BigDecimal itemPrice = Db.getItemPrice(itemId);

            Item item = new Item();
            item.setId(itemId);
            item.setQuantity(quantity);
            item.setPrice(itemPrice);
            items.add(item);
        });
        cart.setItems(items);


        //处理运费和优惠
        items.forEach(item -> {
            item.setDeliveryPrice(BigDecimal.valueOf(0.1).multiply(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))));
            item.setCouponPrice(BigDecimal.ZERO);
        });

//        BigDecimal totalItemPrice = new BigDecimal(ite);
        items.forEach(item -> {
            cart.setTotalItemPrice(items.stream()
                    .map(i -> i.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add));

            cart.setTotalDiscount(items.stream()
                    .map(Item::getCouponPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));

            cart.setTotalDeliveryPrice(items.stream()
                    .map(Item::getDeliveryPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));

            cart.setPayPrice(
                    (cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice())).subtract(cart.getTotalDiscount()));

        });

        return cart;
    }
}
