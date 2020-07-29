package com.javalearning.demo.rabbitmq.compensation;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("user-exchange");
    }

    @Bean
    Queue queue(){
        return new Queue("user-queue");
    }

    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with("user.register.#");
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
