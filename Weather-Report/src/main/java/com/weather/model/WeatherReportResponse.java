package com.weather.model;

import lombok.Data;

import java.util.List;

@Data
public class WeatherReportResponse {

    private String name;
    private Coord coord;
    private Main main;
    private Wind wind;
    private Sys sys;
    private List<Weather> weather;

}
