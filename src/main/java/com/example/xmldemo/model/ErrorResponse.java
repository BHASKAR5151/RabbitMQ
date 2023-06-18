package com.example.xmldemo.model;

public class ErrorResponse {
    public String errorCode ;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorMessage ;

}
