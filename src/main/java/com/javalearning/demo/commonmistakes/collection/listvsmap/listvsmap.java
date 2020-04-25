package com.javalearning.demo.commonmistakes.collection.listvsmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class listvsmap {

    private static int elementCount = 100000;
    private static int loopCount = 1000;

    public static void main(String[] args) {
        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start("list search"); //585ms
        list_search();
        stopWatch2.stop();
        stopWatch2.start("map search"); //46ms
        map_search();
        stopWatch2.stop();
        System.out.println(stopWatch2.prettyPrint());
    }

    private static void list_search(){
        List<Order> list = IntStream.rangeClosed(1, elementCount).mapToObj(i -> new Order(i)).collect(Collectors.toList());
        IntStream.rangeClosed(1,loopCount).forEach(i->{
            int search = ThreadLocalRandom.current().nextInt(list.size());
            Order order1 = list.stream().filter(order -> order.getOrderId() == search).findFirst().get();
            Assert.isTrue(order1 != null && order1.getOrderId() == search);
        });
    }

    private static void map_search(){
        Map<Integer, Order> map = IntStream.rangeClosed(1,elementCount).boxed().collect(Collectors.toMap(Function.identity(), i->new Order(i)));
        IntStream.rangeClosed(1,loopCount).forEach(i->{
            int search = ThreadLocalRandom.current().nextInt(map.size());
            Order order = map.get(search);
            Assert.isTrue(order != null && order.getOrderId() == search);
        });
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Order{
    private int orderId;
}
