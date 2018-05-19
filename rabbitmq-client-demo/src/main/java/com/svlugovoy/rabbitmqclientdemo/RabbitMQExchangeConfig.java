package com.svlugovoy.rabbitmqclientdemo;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

    @Bean
    Exchange my1Exchange() {
        return new TopicExchange("My1Exchange");
    }

    @Bean
    Exchange my2Exchange() {
        return ExchangeBuilder
                .directExchange("My2Exchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange my3Exchange() {
        return ExchangeBuilder
                .topicExchange("My3ExchangeTopic")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange my4Exchange() {
        return ExchangeBuilder
                .fanoutExchange("My4ExchangeFanout")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange my5Exchange() {
        return ExchangeBuilder
                .headersExchange("My5ExchangeHeaders")
                .durable(true)
                .internal()
                .ignoreDeclarationExceptions()
                .build();
    }
}
