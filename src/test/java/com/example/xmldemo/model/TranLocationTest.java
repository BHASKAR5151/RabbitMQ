package com.example.xmldemo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TranLocationTest {

    //@Test
    public void test(){
        TrainLocation trainLocation=  new TrainLocation();
        Assertions.assertNotNull(trainLocation.hashCode());
    }
}
