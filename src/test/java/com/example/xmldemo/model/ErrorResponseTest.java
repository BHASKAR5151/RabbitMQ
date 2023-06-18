package com.example.xmldemo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrorResponseTest {
    @Test
    public void test(){
        ErrorResponse errorResponse=  new ErrorResponse("","");
        Assertions.assertNotNull(errorResponse.hashCode());
    }
}
