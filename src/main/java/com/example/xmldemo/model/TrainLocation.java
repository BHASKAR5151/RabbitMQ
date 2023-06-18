package com.example.xmldemo.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

//@JacksonXmlRootElement(localName = "get-train-location-request")
@Data
public class TrainLocation {
    @JacksonXmlProperty(localName = "train-id")
    private String trainId;
    @JacksonXmlProperty(localName = "location")
    private String location;

}