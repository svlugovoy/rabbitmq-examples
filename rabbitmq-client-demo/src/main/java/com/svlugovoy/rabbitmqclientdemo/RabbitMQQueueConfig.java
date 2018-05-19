package com.svlugovoy.rabbitmqclientdemo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfig {

    @Bean
    Queue my2Queue(){
        return new Queue("My2Queue", false);
    }

    @Bean
    Queue my3Queue(){
        return QueueBuilder
                .durable("My3Queue")
                .autoDelete()
                .exclusive()
                .build();
    }

}
