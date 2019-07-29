package com.svlugovoy.rabbitmqclientdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfig {

    @Bean
    Queue my2Queue(){
        return new Queue("My2_Queue", false);
    }

    @Bean
    Queue my3Queue(){
        return QueueBuilder
                .durable("My3_durable_Queue")
                .autoDelete()
                .exclusive()
                .build();
    }

}
