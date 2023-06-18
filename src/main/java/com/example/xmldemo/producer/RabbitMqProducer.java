package com.example.xmldemo.producer;

import com.example.xmldemo.model.TrainRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProducer {

    @Autowired
    private JmsTemplate template;

    public void sendMessage(String message) {
        template.convertAndSend(message);
    }


    public void sendMessageXml(TrainRequest message) {
        template.convertAndSend(message);
    }
}
