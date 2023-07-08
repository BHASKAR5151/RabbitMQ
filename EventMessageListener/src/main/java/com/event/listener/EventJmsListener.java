package com.rabbitmq.listener;


import com.rabbitmq.model.TrainRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Slf4j
public class RabbiMqJmsListener implements MessageListener {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void onMessage(Message message) {
        log.info(">> Start RabbiMqJmsListener :- onMessage()");
                try {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage objectMessage = (ObjectMessage) message;
                        com.rabbitmq.model.TrainRequest trainRequest= (com.rabbitmq.model.TrainRequest) ( objectMessage.getObject());
                        System.out.println("Train Id: " + trainRequest.getTrainId());
                        System.out.println("Train Type: " + trainRequest.getTrainType());
                        System.out.println("Train Location: " + trainRequest.getTrainLoc());
                        trainRequest.setTrainType("Train type changed by JMS Listener");
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_XML);
                        String url="http://localhost:8080/rabbitmq/message-from-listener";

                        restTemplate.exchange(
                                url,
                                HttpMethod.POST,
                                new HttpEntity<>(trainRequest, headers),
                                TrainRequest.class
                        );

                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
        log.info("<< End RabbiMqJmsListener :- onMessage()");
    }
}
