package com.example.xmldemo.cotroller;

import com.example.xmldemo.model.TrainLocation;
import com.example.xmldemo.controller.TrainController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class TrainControllerTest {

    @InjectMocks
    TrainController trainController;

    //@Test
    public void testValidTrainId() {
        TrainLocation trainLocation = new TrainLocation();
        trainLocation.setTrainId("TRAIN72");
        ResponseEntity<Object> response = trainController.xmlSingleObject(trainLocation);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(trainLocation, response.getBody());
        Assertions.assertEquals("omaha", trainLocation.getLocation());
    }
    //@Test
    public void testInValidTrainId() {
        TrainLocation trainLocation = new TrainLocation();
        trainLocation.setTrainId("TRAIN75");
        ResponseEntity<Object> response = trainController.xmlSingleObject(trainLocation);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}
