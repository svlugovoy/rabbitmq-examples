package com.svlugovoy.rabbitmqclientdemo.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

    @Bean
    Exchange my1Exchange() {
        return new TopicExchange("My1_TopicExchange");
    }

    @Bean
    Exchange my2Exchange() {
        return ExchangeBuilder
                .directExchange("My2_directExchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange my3Exchange() {
        return ExchangeBuilder
                .topicExchange("My3_topicExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange my4Exchange() {
        return ExchangeBuilder
                .fanoutExchange("My4_fanoutExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange my5Exchange() {
        return ExchangeBuilder
                .headersExchange("My5_headersExchange")
                .durable(true)
                .internal()
                .ignoreDeclarationExceptions()
                .build();
    }
}
