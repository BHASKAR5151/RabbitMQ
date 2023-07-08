package com.rabbitmq.producer;

import com.rabbitmq.model.TrainRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMqProducer {

    @Autowired
    private JmsTemplate template;

    public void produceMessage(TrainRequest message) {
        log.info(">> Start RabbitMqProducer :- produceMessage()");
        template.convertAndSend(message);
        log.info("<< End RabbitMqProducer :- produceMessage()");
    }
}
