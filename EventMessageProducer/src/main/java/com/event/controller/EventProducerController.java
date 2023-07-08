package com.message.controller;

import com.rabbitmq.model.TrainRequest;
import com.rabbitmq.producer.RabbitMqXmlProducer;
import com.rabbitmq.service.RabbitMqXmlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/rabbitmq")
public class MessageProcessingController {

    @Autowired
    private RabbitMqXmlProducer rabbitMqProducer;

    @Autowired
    RabbitMqXmlService rabbitMqXmlService;

    @PostMapping(value = "/message-save-update", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public String saveMessage(@RequestBody TrainRequest trainRequest) {
        log.info(">> Start MessageProcessingController :- saveMessage()");
        if (null != trainRequest.getTrainId()) {
            rabbitMqXmlService.persist(trainRequest);
        }
        log.info("<< End MessageProcessingController :- saveMessage()");
        return "Success";
    }

    @PostMapping(value = "/message-from-listener", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public void messageFromListener(@RequestBody TrainRequest trainRequest) {
        log.info(">> Start MessageProcessingController :- messageFromListener()");
        System.out.println("Train Id: " + trainRequest.getTrainId());
        System.out.println("Train Type: " + trainRequest.getTrainType());
        System.out.println("Train Location: " + trainRequest.getTrainLoc());
        log.info("<< End MessageProcessingController :- messageFromListener()");

    }




}
