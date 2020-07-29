package com.javalearning.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMQApplication {

//    public static String exchange = "any-exchange";
//    public static String queue = "any-queue";
//
//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange(exchange);
//    }
//
//    @Bean
//    public Queue queue(){
//        return new Queue(queue);
//    }
//
//    @Bean
//    public Binding binding(TopicExchange exchange, Queue queue){
//        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
//    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}

