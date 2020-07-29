package com.javalearning.demo.rabbitmq.fanoutvswork;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanoutvswork")
public class WrokQueueRight {

    public static String exchange = "new-user-exchange-2";
    public static String queue = "new-user-queue-2";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public void sendMessage(){
        rabbitTemplate.convertAndSend(exchange, "", "hello from the other side");
    }

//    @Bean
    public Queue queue(){
        //只要是监听同一个queue就属于一个组，一个组内多个服务在接收到消息的时候只有一个服务消费消息
        return new Queue(queue);
    }

//    @Bean
    public Declarables declarables(){
        TopicExchange directExchange = new TopicExchange(exchange);
        return new Declarables(queue(), directExchange,
                BindingBuilder.bind(queue()).to(directExchange).with(""));
    }

    @RabbitListener(queues = "new-user-queue-2")
    public void listen(String message){
        System.out.println("receive message: " + message + ", port: " + System.getProperty("server.port"));
    }
}
