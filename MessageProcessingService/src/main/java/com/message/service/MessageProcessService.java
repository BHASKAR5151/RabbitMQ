package com.message.service;

import com.message.model.TrainRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MessageProcessingService {
    Map<String, TrainRequest> globalMap = new HashMap<>();

    public void persist(TrainRequest trainRequest) {
        log.info(">> Start RabbitMqXmlService :- persist()");
        if(globalMap.containsKey(trainRequest.getTrainId())) {
            globalMap.put(trainRequest.getTrainId(), trainRequest);
        }else {
            globalMap.put(trainRequest.getTrainId(), trainRequest);
        }
        
        log.info("<< End RabbitMqXmlService :- persist()");
    }
}
