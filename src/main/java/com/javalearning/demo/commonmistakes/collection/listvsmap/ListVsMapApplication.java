package com.javalearning.demo.commonmistakes.collection.listvsmap;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListVsMapApplication {

    public static void main(String[] args) throws InterruptedException {
        int elementCount = 1000000;
        int loopCount = 1000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("listSearch");
        Object list = listSearch(elementCount, loopCount);
        System.out.println(ObjectSizeCalculator.getObjectSize(list));
        stopWatch.stop();
        stopWatch.start("mapSearch");
        Object map = mapSearch(elementCount, loopCount);
        stopWatch.stop();
        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(stopWatch.prettyPrint());
        TimeUnit.HOURS.sleep(1);
    }

    private static Object listSearch(Integer elementCount, Integer loopCount){
        List<Order> list = IntStream.rangeClosed(1, elementCount)
                .mapToObj(i -> new Order(i)).collect(Collectors.toList());
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int orderId = ThreadLocalRandom.current().nextInt(elementCount);
            Order order1 = list.stream().filter(order -> order.getOrderId() == orderId).findFirst().orElse(null);
            Assert.isTrue(order1 != null && order1.getOrderId() == orderId);
        });
        return list;
    }

    private static Object mapSearch(Integer elementCount, Integer loopCount){
        Map<Integer, Order> map = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toMap(Function.identity(), i -> new Order(i)));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int orderId = ThreadLocalRandom.current().nextInt(elementCount);
            Order order = map.get(orderId);
            Assert.isTrue(order != null && order.getOrderId() == orderId);
        });
        return map;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Order {
        private int orderId;
    }
}

