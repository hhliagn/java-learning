package com.javalearning.demo.rabbitmq;

import com.javalearning.demo.rabbitmq.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) {
        System.out.println("sending message...");
        try {
            User user = new User();
            user.setName("liang henghui");
            user.setAge(23);
            rabbitTemplate.convertAndSend("any-exchange-2", "foo.bar.zar", user);
        } catch (AmqpException e) {
            log.error("发送消息异常", e);
        }
    }
}
