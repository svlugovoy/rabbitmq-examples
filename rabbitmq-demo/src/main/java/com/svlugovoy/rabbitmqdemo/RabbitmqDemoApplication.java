package com.svlugovoy.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqDemoApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(5000);
            rabbitTemplate.convertAndSend("TestExchange", "r_key", "hello " + i);
            rabbitTemplate.convertAndSend("MyTopicExchange", "rout_key", "hello " + i);
            MyMessage message = new MyMessage();
            message.setName("name " + i);
            message.setDescription("Some desc...");
            rabbitTemplate.convertAndSend("MyTopicExchange", "rout_key", message);
            rabbitTemplate.convertAndSend("MyTopicExchange", "rout_key", message.toString());
        }
    }
}
