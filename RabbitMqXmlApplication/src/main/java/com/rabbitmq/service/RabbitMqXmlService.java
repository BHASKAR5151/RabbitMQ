package com.rabbitmq.service;

import com.rabbitmq.model.TrainRequest;
import com.rabbitmq.producer.RabbitMqProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class RabbitMqService {

    Map<String,TrainRequest> globalMap = new HashMap<>();
    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    public void persist(TrainRequest trainRequest) {
        log.info(">> Start RabbitMqService :- persist()");
        if(globalMap.containsKey(trainRequest.getTrainId())) {
            globalMap.put(trainRequest.getTrainId(), trainRequest);
        }else {
            globalMap.put(trainRequest.getTrainId(), trainRequest);
        }
        rabbitMqProducer.produceMessage(globalMap.get(trainRequest.getTrainId()));
        log.info("<< End RabbitMqService :- persist()");
    }
}
