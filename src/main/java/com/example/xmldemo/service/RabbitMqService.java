package com.example.xmldemo.service;

import com.example.xmldemo.model.TrainRequest;
import com.example.xmldemo.producer.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitMqService {

    Map<String,TrainRequest> globalMap = new HashMap<>();

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    public void persist(TrainRequest trainRequest) {
        if(globalMap.containsKey(trainRequest.getTrainId())) {
            //TrainRequest existedTrainRequest = globalMap.get(trainRequest.getTrainId());
            globalMap.put(trainRequest.getTrainId(), trainRequest);
        }else {
            globalMap.put(trainRequest.getTrainId(), trainRequest);
        }
        rabbitMqProducer.sendMessageXml(globalMap.get(trainRequest.getTrainId()));
    }
}
