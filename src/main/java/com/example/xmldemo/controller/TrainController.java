package com.example.xmldemo.controller;


import com.example.xmldemo.model.ErrorResponse;
import com.example.xmldemo.model.TrainLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TrainController {


    @PostMapping(value = "/xml-single-obj", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> xmlSingleObject(@RequestBody TrainLocation trainLocation) {

        //Map object need to know how the response will look like
        List<TrainLocation> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("TRAIN72","omaha");
        map.put("train21","nebrasaka");
        map.put("TRAIN73","HYD");
        map.put("TRAIN74","BLR");
        /*16591, Hampi express, Dharmavaram
        07590,Tirupathi express, Thirupathi
        06516,Satya sai express, Puttaparthi*/

        if(map.containsKey(trainLocation.getTrainId())) {
            trainLocation.setLocation(map.get(trainLocation.getTrainId()));
            return ResponseEntity.status(HttpStatus.OK).body(trainLocation);
        }
        else{
            ErrorResponse errorResponse = new ErrorResponse("400", "Bad Request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

}
