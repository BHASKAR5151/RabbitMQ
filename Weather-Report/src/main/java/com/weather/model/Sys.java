package com.weather.model;

import lombok.Data;

@Data
public class Sys {
        private int type;
        private int id;
        private String country;
        private long sunrise;
        private long sunset;
}
