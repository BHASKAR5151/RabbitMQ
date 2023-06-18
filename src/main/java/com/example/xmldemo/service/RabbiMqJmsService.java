package com.example.xmldemo.service;

import com.example.xmldemo.model.TrainRequest;

import javax.jms.*;

public class RabbiMqJmsService implements MessageListener {

    @Override
    public void onMessage(Message message) {
                try {
                    if (message instanceof ObjectMessage) {
                        ObjectMessage objectMessage = (ObjectMessage) message;
                        TrainRequest trainRequest = (TrainRequest) objectMessage.getObject();
                        System.out.println("Train Id: " + trainRequest.getTrainId());
                        System.out.println("Train Type: " + trainRequest.getTranType());
                        System.out.println("Train Location: " + trainRequest.getTrainLoc());

                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
}
