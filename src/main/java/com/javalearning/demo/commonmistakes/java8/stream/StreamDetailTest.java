package com.javalearning.demo.commonmistakes.java8.stream;


import com.javalearning.demo.commonmistakes.java8.lambda.Product;
import com.javalearning.demo.commonmistakes.java8.stream.collector.MostPopularCollector;
import com.javalearning.demo.commonmistakes.java8.stream.model.Order;
import com.javalearning.demo.commonmistakes.java8.stream.model.OrderItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StreamDetailTest {
    private static Random random = new Random();
    private List<Order> orders;

    @Before
    public void data() {
        orders = Order.getData();

        orders.forEach(System.out::println);
        System.out.println("==========================================");
    }

    @Test
    public void filter() {
        System.out.println("//最近半年的金额大于40的订单");
        orders.stream().filter(Objects::nonNull)
                .filter(order -> order.getPlacedAt().isAfter(LocalDateTime.now().minusMonths(6)))
                .filter(order -> order.getTotalPrice() > 40)
                .forEach(System.out::println);
    }

    @Test
    public void filter1() {
        orders.stream()
                .filter(order -> order.getTotalPrice() > 40)
                .filter(order -> order.getPlacedAt().isAfter(LocalDateTime.now().minusMonths(6)));
    }

    @Test
    public void map() {
        LongAdder longAdder = new LongAdder();

        //统计订单的所有商品数量

        //遍历两次
        orders.stream().forEach(order -> order.getOrderItemList().stream()
                .forEach(orderItem -> longAdder.add(orderItem.getProductQuantity())));


        //两次mapLong + sum
        Assert.assertThat(longAdder.longValue(), is(orders.stream()
                .mapToLong(order -> order.getOrderItemList().stream()
                        .mapToLong(orderItem -> orderItem.getProductQuantity()).sum()).sum()));
//

        //IntStream 转换Product
        System.out.println(IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Product((long) i, "product" + i, i * 100.0))
                .collect(toList()));
    }

    @Test
    public void map1(){
        LongAdder longAdder = new LongAdder();
        orders.stream().forEach(order -> order.getOrderItemList()
                .stream().forEach(orderItem -> longAdder.add(orderItem.getProductQuantity())));

        Assert.assertThat(orders.stream().mapToLong(order -> order.getOrderItemList().stream()
                .mapToLong(orderItem -> orderItem.getProductQuantity()).sum()).sum(), is(longAdder.longValue()));

    }

    @Test
    public void sorted(){
        System.out.println("//大于50的订单,按照订单价格倒序前5");
        orders.stream().filter(order -> order.getTotalPrice() > 50)
                .sorted(comparing(Order::getTotalPrice).reversed())
                .limit(5)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void flatMap() {
        System.out.println(orders.stream().mapToDouble(Order::getTotalPrice).sum());

        System.out.println(orders.stream()
                .flatMap(order -> order.getOrderItemList().stream())
                .mapToDouble(OrderItem::getProductPrice).sum());

        System.out.println(orders.stream()
                .flatMapToDouble(order -> order.getOrderItemList().stream()
                        .mapToDouble(OrderItem::getProductQuantity)).sum());
    }

    public void flatmap(){
        System.out.println(orders.stream().mapToDouble(Order::getTotalPrice).sum());

        System.out.println(orders.stream().flatMap(order -> order.getOrderItemList().stream())
        .mapToDouble(OrderItem::getProductPrice).sum());

        System.out.println(orders.stream().flatMapToDouble(order -> order.getOrderItemList().stream()
                .mapToDouble(OrderItem::getProductPrice)).sum());
    }

    @Test
    public void groupBy() {
        System.out.println("//按照用户名分组，统计下单数量");
        System.out.println(orders.stream()
                .collect(groupingBy(Order::getCustomerName, counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(toList()));

        System.out.println(orders.stream()
        .collect(groupingBy(Order::getCustomerName, counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(toList()));


        System.out.println("//按照用户名分组,统计订单总金额");
        System.out.println(orders.stream()
                .collect(groupingBy(Order::getCustomerName, summingDouble(Order::getTotalPrice)))
        .entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(toList()));

        System.out.println(orders.stream()
        .collect(groupingBy(Order::getCustomerName, summingDouble(Order::getTotalPrice)))
        .entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(toList()));

        System.out.println("//按照用户名分组,统计商品采购数量");
        System.out.println(orders.stream()
                .collect(
                        groupingBy(Order::getCustomerName,
                                summingDouble(order -> order.getOrderItemList().stream()
                                        .collect(summingInt(OrderItem::getProductQuantity)))))
                .entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(toList()));

        System.out.println(orders.stream()
        .collect(groupingBy(Order::getCustomerName, summingDouble(order -> order.getOrderItemList().stream()
                .collect(summingInt(OrderItem::getProductQuantity)))))
        .entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
        .collect(toList()));


        System.out.println("//统计最受欢迎的商品，倒序后取第一个");
        orders.stream().flatMap(order -> order.getOrderItemList().stream())
                .collect(groupingBy(
                        OrderItem::getProductName, summingInt(OrderItem::getProductQuantity)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);


        System.out.println("//统计最受欢迎的商品的另一种方式,直接利用maxBy");
        orders.stream().flatMap(order -> order.getOrderItemList().stream())
                .collect(groupingBy(OrderItem::getProductName, summingInt(OrderItem::getProductQuantity)))
                .entrySet().stream()
                .collect(maxBy(Map.Entry.comparingByValue()))
                .ifPresent(System.out::println);

        System.out.println("//按照用户名分组，选用户下的总金额最大的订单");
        orders.stream()
                .collect(groupingBy(Order::getCustomerName,
                        collectingAndThen(maxBy(comparing(Order::getTotalPrice)), Optional::get)))
                .forEach((k, v) -> System.out.println(k + '#' + v.getTotalPrice() + '@' + v.getPlacedAt()));

        System.out.println("//根据下单年月分组统计订单ID列表");
        System.out.println(orders.stream()
        .collect(groupingBy(order -> order.getPlacedAt()
                .format(DateTimeFormatter.ofPattern("yyyyMM")), mapping(Order::getId, toList()))));

        System.out.println("//根据下单年月+用户名两次分组，统计订单ID列表");
        System.out.println(orders.stream()
                .collect(
                        groupingBy(order -> order.getPlacedAt().format(DateTimeFormatter.ofPattern("yyyyMM"))
                        , groupingBy(Order::getCustomerName, mapping(Order::getId, toList())))));
    }

    @Test
    public void maxMin(){
        orders.stream().max(comparing(Order::getTotalPrice)).ifPresent(System.out::println);
        orders.stream().min(comparing(Order::getTotalPrice)).ifPresent(System.out::println);
    }

    @Test
    public void reduce(){
        System.out.println("//统计花钱最多的人");
        System.out.println(orders.stream()
                .collect(groupingBy(Order::getCustomerName, summingDouble(Order::getTotalPrice)))
                .entrySet().stream()
                .reduce(BinaryOperator.maxBy(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey).orElse("N/A"));
    }

    @Test
    public void distinct() {
        System.out.println("不去重的用户");
        System.out.println(orders.stream().map(Order::getCustomerName).collect(Collectors.joining(",")));


        System.out.println("去重的用户");
        System.out.println(orders.stream().map(Order::getCustomerName).distinct().collect(Collectors.joining(",")));


        System.out.println("去重的商品");
        System.out.println(orders.stream().flatMap(order -> order.getOrderItemList().stream())
                .map(OrderItem::getProductName).distinct().collect(Collectors.joining(",")));
    }

    @Test
    public void collect() {
        System.out.println("//生成一定位数的随机字符串");
        System.out.println(random.ints(48,122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(20)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString());

        System.out.println("//所有下单的用户,使用toSet去重了");
        System.out.println(orders.stream()
                .map(Order::getCustomerName)
                .collect(toSet()).stream()
                .collect(Collectors.joining(",")));

        System.out.println("//用toCollection收集器指定集合类型");
        System.out.println(orders.stream().limit(2).collect(toCollection(LinkedList::new)).getClass());

        System.out.println("//使用toMap获取订单ID+下单用户名的Map");
        orders.stream().collect(toMap(Order::getId, Order::getCustomerName))
                .entrySet().forEach(System.out::println);

        System.out.println("//使用toMap获取下单用户名+最近一次下单时间的Map");
        //There are multiple ways to deal with collisions between multiple elements mapping to the same key.
        orders.stream()
                .collect(toMap(Order::getId, Order::getPlacedAt, (x,y) -> x.isAfter(y)? x: y))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("//订单平均购买的商品数量");
        System.out.println(orders.stream()
                .collect(averagingInt(order -> order.getOrderItemList().stream()
                        .collect(summingInt(OrderItem::getProductQuantity)))));
    }

    @Test
    public void partition() {
        //先来看一下所有下单的用户
        orders.stream().map(Order::getCustomerName).collect(toSet()).forEach(System.out::println);
        //根据是否有下单记录进行分区
        System.out.println(Customer.getData().stream()
                        .collect(partitioningBy(customer -> orders.stream()
                                .mapToLong(Order::getCustomerId)
                                .anyMatch(id -> id == customer.getId()))));
    }

    @Test
    public void skipLimit() {
        orders.stream().sorted(comparing(Order::getPlacedAt))
                .map(order -> order.getCustomerName() + '@' + order.getPlacedAt())
                .limit(2).forEach(System.out::println);

        orders.stream().sorted(comparing(Order::getPlacedAt))
                .map(order -> order.getCustomerName() + '@' + order.getPlacedAt())
                .skip(2).limit(2).forEach(System.out::println);
    }

    @Test
    public void peek() { //多个peek都是一次走完
        orders.stream().filter(order -> order.getTotalPrice() > 40)
                .peek(order -> System.out.println(order.toString()))
                .map(Order::getCustomerName)
                .peek(System.out::println)
                .collect(toList());

        System.out.println(Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(toList()));
    }

    @Test
    public void customCollector() //自定义收集器
    {
        //最受欢迎收集器
        assertThat(Stream.of(1, 1, 2, 2, 2, 3, 4, 5, 5).collect(new MostPopularCollector<>()).get(), is(2));
        assertThat(Stream.of('A', 'b', 'c', 'c', 'c', 'd').collect(new MostPopularCollector<>()).get(), is('c'));
        assertThat(Stream.concat(Stream.concat(IntStream.rangeClosed(1, 1000).boxed(), IntStream.rangeClosed(1, 1000).boxed()), Stream.of(2))
                .parallel().collect(new MostPopularCollector<>()).get(), is(2));

    }


}
