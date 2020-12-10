package com.javalearning.demo.concurrency.thread_pool.split_task;

public class OrderInfoServiceImpl implements OrderInfoService {
    @Override
    public void insert(OrderInfo orderInfo) {
        System.out.println("insert: " + orderInfo);
    }
}
