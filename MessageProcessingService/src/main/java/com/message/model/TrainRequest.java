package com.rabbitmq.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;

@Data
@JacksonXmlRootElement(localName = "jms-train-request")
public class TrainRequest implements Serializable {

    @JacksonXmlProperty(localName = "train-id")
    public String trainId;
    @JacksonXmlProperty(localName = "train-type")
    public String trainType;

    @JacksonXmlProperty(localName = "train-loc")
    public String trainLoc;


}
