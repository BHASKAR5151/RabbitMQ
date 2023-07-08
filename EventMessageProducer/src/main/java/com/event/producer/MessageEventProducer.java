package com.event.producer;

import com.event.model.TrainRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageEventProducer {

    @Autowired
    private JmsTemplate template;

    public void produceMessage(TrainRequest message) {
        log.info(">> Start MessageEventProducer :- produceMessage()");
        template.convertAndSend(message);
        log.info("<< End MessageEventProducer :- produceMessage()");
    }
}
