package com.svlugovoy.rabbitmqdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class RabbitmqDemoApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
    }

    @GetMapping("/run")
    public void goWork() throws InterruptedException {
        work(5);
    }

    @Override
    public void run(String... args) throws Exception {
//        work(10);
    }

    private void work(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            Thread.sleep(5000);
            rabbitTemplate.convertAndSend("MyTopicExchange", "rout_key", "hello " + i);

            MyMessage message = new MyMessage();
            message.setName("name " + i);
            message.setDescription("Some desc...");

            rabbitTemplate.convertAndSend("MyTopicExchange", "rout_key", message);
            rabbitTemplate.convertAndSend("MyTopicExchange", "rout_key", message.toString());

            log.info("Messages sent to Rabbit... {}", i);
        }
    }
}
