package com.javalearning.demo.concurrency.thread_pool.split;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InsertTask implements Runnable {

    private List<OrderInfo> orders;
    private OrderInfoService orderInfoService = new OrderInfoServiceImpl();
    private static AtomicInteger counter = new AtomicInteger(0);

    public InsertTask(List<OrderInfo> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {
        for (OrderInfo order : orders) {
            System.out.println(Thread.currentThread().getName() + ": " + order.getOrderId());
            System.out.println("counter: " + counter.incrementAndGet());
        }
    }
}
