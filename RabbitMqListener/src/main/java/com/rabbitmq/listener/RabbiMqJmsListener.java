package com.rabbitmq.service;


import com.rabbitmq.model.TrainRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class RabbiMqJmsListener implements MessageListener {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void onMessage(Message message) {
                try {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage objectMessage = (ObjectMessage) message;
                        com.rabbitmq.model.TrainRequest trainRequest= (com.rabbitmq.model.TrainRequest) ( objectMessage.getObject());
                        //TrainRequest trainRequest = (TrainRequest) objectMessage.getObject();
                        System.out.println("Train Id: " + trainRequest.getTrainId());
                        System.out.println("Train Type: " + trainRequest.getTrainType());
                        System.out.println("Train Location: " + trainRequest.getTrainLoc());

                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_XML);
                        String url="http://localhost:9090/api/service";

                        ResponseEntity<TrainRequest> response = restTemplate.exchange(
                                url,
                                HttpMethod.POST,
                                new HttpEntity<>(trainRequest, headers),
                                TrainRequest.class
                        );
                        TrainRequest responseObj = response.getBody();
                        System.out.println("New Train Type:"+responseObj.getTrainType());
                       // ResponseEntity<String> response = restTemplate.getForEntity(", String.class);
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
}
