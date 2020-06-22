package com.javalearning.demo.commonmistakes.redundantcode.templatemethod.wrong;

import com.javalearning.demo.commonmistakes.redundantcode.Db;
import com.javalearning.demo.commonmistakes.redundantcode.templatemethod.Cart;
import com.javalearning.demo.commonmistakes.redundantcode.templatemethod.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NormalUserCart {

    public void process(Long userId, Map<Long,Integer> map){

        Cart cart = new Cart();
        List<Item> items = new ArrayList<>();
        map.entrySet().stream().forEach(entry -> {

            Long itemId = entry.getKey();
            BigDecimal itemPrice = Db.getItemPrice(itemId);
            Integer quantity = entry.getValue();

            Item item = new Item();
            item.setId(itemId);
            item.setQuantity(quantity);
            item.setPrice(itemPrice);
            items.add(item);
        });
        cart.setItems(items);


        //处理运费和优惠
//        items.stream().forEach(item -> {
//            item.setDeliveryPrice(item.get);
//        });




    }
}
