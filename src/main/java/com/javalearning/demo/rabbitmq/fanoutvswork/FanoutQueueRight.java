package com.javalearning.demo.rabbitmq.fanoutvswork;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanoutqueue")
public class FanoutQueueRight {

    private static final String memberQueue = "new-member-queue-10";
    private static final String userQueue = "new-user-queue-10";
    private static final String exchange = "new-exchange";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public void sendMessage(){
        rabbitTemplate.convertAndSend(exchange, "", "this is a message!");
    }

    @Bean
    public Declarables declarables(){
        Queue member_queue = new Queue(memberQueue);
        Queue user_queue = new Queue(userQueue);

        DirectExchange exchange = new DirectExchange("new-exchange");

        return new Declarables(member_queue, user_queue, exchange,
                BindingBuilder.bind(member_queue).to(exchange).with(""),
                BindingBuilder.bind(user_queue).to(exchange).with(""));
    }

    @RabbitListener(queues = memberQueue)
    public void usre1(String message){
        System.out.println("user1 receiver message: " + message);
    }

    @RabbitListener(queues = memberQueue)
    public void user2(String message){
        System.out.println("user2 receiver message: " + message);
    }

    @RabbitListener(queues = userQueue)
    public void member1(String message){
        System.out.println("member1 receiver message: " + message);
    }

    @RabbitListener(queues = userQueue)
    public void member2(String message){
        System.out.println("member2 receiver message: " + message);
    }


}
