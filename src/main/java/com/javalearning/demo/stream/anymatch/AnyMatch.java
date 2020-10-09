package com.javalearning.demo.stream.anymatch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnyMatch {

    /**
     * anyMatch: 检查列表中是否有元素满足断言，如果有，返回true，否则返回false
     */
    public static void main(String[] args) {
        List<OrderInfo> orders = getOrders();
        List<OrderInfo> ordersWhichItemsWasPresent = orders.stream()
                .filter(order -> order.getItems().stream()
                        .anyMatch(item -> item.getIfPresent().equals(1)))
                .collect(Collectors.toList());
        ordersWhichItemsWasPresent.forEach(System.out::println);
    }

    private static List<OrderInfo> getOrders() {
        List<OrderInfo> resList = new ArrayList<>(10);
        for (int i = 0; i < resList.size(); i++) {
            resList.add(new OrderInfo());
        }
        return resList;
    }
}
