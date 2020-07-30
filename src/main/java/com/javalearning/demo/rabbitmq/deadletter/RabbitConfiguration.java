package com.javalearning.demo.rabbitmq.deadletter;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

@Configuration
public class RabbitConfiguration {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    Declarables declarables(){
        DirectExchange exchange = new DirectExchange(MQConst.workExchange);
        Queue queue = new Queue(MQConst.workQueue);
        return new Declarables(queue, exchange, BindingBuilder.bind(queue).to(exchange).with(MQConst.workRouteKey));
    }

    @Bean
    Declarables declarablesForDead(){
        DirectExchange exchange = new DirectExchange(MQConst.deadExchange);
        Queue queue = new Queue(MQConst.deadQueue);
        return new Declarables(queue, exchange, BindingBuilder.bind(queue).to(exchange).with(MQConst.deadRouteKey));
    }

    @Bean
    RetryOperationsInterceptor interceptor(){
        return RetryInterceptorBuilder
                .stateless()
                .maxAttempts(5)
                .backOffOptions(1000, 2.0, 100000)
                .recoverer(new RepublishMessageRecoverer(rabbitTemplate, MQConst.deadExchange, MQConst.deadRouteKey))
                .build();
    }


    //bug here
    //这个方法的名字必须是rabbitListenerContainerFactory，否则factory设置不会生效
    @Bean
    SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAdviceChain(interceptor());
        factory.setConcurrentConsumers(10);
        return factory;
    }

//    @Bean
//    public SimpleRabbitListenerContainerFactory factory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setAdviceChain(interceptor());
//        factory.setConcurrentConsumers(10);
//        return factory;
//    }
}
