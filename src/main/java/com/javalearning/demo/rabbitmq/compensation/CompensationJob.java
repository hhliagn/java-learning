package com.javalearning.demo.rabbitmq.compensation;


import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CompensationJob {

    private static ThreadPoolExecutor threadPoolExecutor
            = new ThreadPoolExecutor(
                    10, 10, 1, TimeUnit.HOURS,
            new ArrayBlockingQueue<>(100),
            ThreadFactoryBuilder.create().setNameFormat("").get());

    @Autowired
    private UserService userService;

    @Autowired
    private VipService vipService;

    private Integer offset = 0;

    @Scheduled(initialDelay = 10000, fixedRate = 3000)
    public void compensation(){
        List<User> users = userService.getUserWithLimit(offset, 5);
        users.forEach(user -> {
            threadPoolExecutor.execute(() -> {
                vipService.welcome(user);
                offset = user.getId();
            });
        });
    }
}
