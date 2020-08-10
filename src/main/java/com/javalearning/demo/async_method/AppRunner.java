package com.javalearning.demo.async_method;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        long begin = System.currentTimeMillis();

        CompletableFuture<User> user1 = userService.findUser("PivotalSoftware");
        CompletableFuture<User> user2 = userService.findUser("CloudFoundry");
        CompletableFuture<User> user3 = userService.findUser("Spring-Projects");

        CompletableFuture.allOf(user1, user2, user3).join();

        log.info("Elaspe time : {}", System.currentTimeMillis() - begin);
        log.info("user1 : {}", user1.get());
        log.info("user2 : {}", user2.get());
        log.info("user3 : {}", user3.get());
    }
}
