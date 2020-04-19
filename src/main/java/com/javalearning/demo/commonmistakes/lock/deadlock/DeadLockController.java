package com.javalearning.demo.commonmistakes.lock.deadlock;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("deadlock")
@RestController
public class DeadLockController {

    private Map<String, Item> items = new ConcurrentHashMap<>();

    public DeadLockController(){
        IntStream.range(0,10).parallel().forEach(i->items.put("item" + i, new Item("item" + i)));
    }

    public List<Item> createCart(){
        return IntStream.rangeClosed(1,3)
                .mapToObj(i->"item"+ThreadLocalRandom.current().nextInt(items.size()))
                .map(name->items.get(name)).collect(Collectors.toList());
    }

    public boolean createOrder(List<Item> items){
        List<ReentrantLock> locks= new ArrayList<>();
        for (Item item : items) {
            try {
                if (item.lock.tryLock(10, TimeUnit.SECONDS)){
                    locks.add(item.lock);
                }
            }catch (InterruptedException e){
                locks.forEach(ReentrantLock::unlock);
                return false;
            }
        }
        try {
            items.forEach(item -> item.remaining--);
        } finally {
            locks.forEach(ReentrantLock::unlock);
        }
        return true;
    }

    @GetMapping("wrong")
    public long wrong() {
        long begin = System.currentTimeMillis();
        //并发进行100次下单操作，统计成功次数
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = createCart();
                    return createOrder(cart);
                })
                .filter(result -> result)
                .count();
        log.info("success:{} totalRemaining:{} took:{}ms items:{}",
                success,
                items.entrySet().stream().map(item -> item.getValue().remaining).reduce(0, Integer::sum),
                System.currentTimeMillis() - begin, items);
        return success;
    }

    @GetMapping("right")
    public long right() {
        long begin = System.currentTimeMillis();
        //并发进行100次下单操作，统计成功次数
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = createCart().stream()
                            .sorted(Comparator.comparing(Item::getName))
                            .collect(Collectors.toList());
                    return createOrder(cart);
                })
                .filter(result -> result)
                .count();
        log.info("success:{} totalRemaining:{} took:{}ms items:{}",
                success,
                items.entrySet().stream().map(item -> item.getValue().remaining).reduce(0, Integer::sum),
                System.currentTimeMillis() - begin, items);
        return success;
    }

    @Data
    @RequiredArgsConstructor
    static class Item{
        final String name;
        int remaining = 1000;

        @ToString.Exclude
        ReentrantLock lock = new ReentrantLock();
    }
}