package com.javalearning.demo.concurrency.thread_pool.split_task;

import com.javalearning.demo.concurrency.thread_pool.demo.GlobalThreadPool;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = GlobalThreadPool.getThreadPoolExecutor();

        Date now = new Date();
        List<OrderInfo> orderInfos = IntStream.rangeClosed(1, 2_000_000).mapToObj(i -> {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderId(i);
            orderInfo.setCompanyId(24);
            orderInfo.setUserId(11309);
            orderInfo.setCreateTime(now);
            return orderInfo;
        }).collect(Collectors.toList());

        log.info("orderInfos size: {}", orderInfos.size());

        int period = 10_000;
        int time = orderInfos.size() % period == 0 ? orderInfos.size() / period : orderInfos.size() / period + 1;

        for (int i = 0; i < time; i++) {
           threadPoolExecutor.execute(
                   new InsertTask(orderInfos.subList(i * period, i * period + period)));
        }

        try {
            threadPoolExecutor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown();
    }
}
