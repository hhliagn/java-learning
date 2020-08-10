package com.javalearning.demo.async_method;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<User> findUser(String username) throws InterruptedException {
        log.info("Look up for user " + username);
        String url = String.format("https://api.github.com/users/%s", username);
        User result = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(result);
    }
}
