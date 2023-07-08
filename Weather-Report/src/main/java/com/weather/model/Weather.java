package com.weather.model;

import lombok.Data;

@Data
public class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
}
