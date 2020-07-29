package com.javalearning.demo.rabbitmq.compensation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class VipService {

    private Map<Integer, Boolean> quchongmap = new HashMap<>();

    @RabbitListener(queues = "user-queue")
    public void listen(User user){
        log.info("用户注册，vip服务发放礼品");
        welcome(user);
    }

    public void welcome(User user){
        Integer userId = user.getId();
        if (quchongmap.putIfAbsent(userId, true) == null){
            log.info("补偿用户，userId = {}", userId);
        }
    }
}
