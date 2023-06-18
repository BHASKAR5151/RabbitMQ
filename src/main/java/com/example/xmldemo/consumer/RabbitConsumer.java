package com.example.xmldemo.consumer;

import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {

    //@RabbitListener(queues = MessagingConfig.QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Consumer received message: " + message);
    }
}
