package com.example.xmldemo.controller;

import com.example.xmldemo.model.ErrorResponse;
import com.example.xmldemo.model.TrainRequest;
import com.example.xmldemo.producer.RabbitMqProducer;
import com.example.xmldemo.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    @Autowired
    RabbitMqService rabbitMqService;

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody String message) {
        rabbitMqProducer.sendMessage(message);
        return "Success";
    }

    @PostMapping(value = "/send-message-xml", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public String sendMessageXml(@RequestBody TrainRequest trainRequest) {
        rabbitMqProducer.sendMessageXml(trainRequest);
        return "Success";
    }

    @PostMapping(value = "/send-message-save-update", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public String sendMessageXmlSave(@RequestBody TrainRequest trainRequest) {
        if (null != trainRequest.getTrainId()) {
            rabbitMqService.persist(trainRequest);
        }
        return "Success";
    }


}
