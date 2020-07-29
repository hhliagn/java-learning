package com.javalearning.demo.rabbitmq.compensation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.stream.IntStream;

@Slf4j
@Component
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = new User(i, UUID.randomUUID().toString());
            userService.register(user);
            if (i % 2 == 0){
                rabbitTemplate.convertAndSend("user-exchange", "user.register.baz", user);
                log.info("发送消息，user = {}", user);
            }
        });
    }
}
