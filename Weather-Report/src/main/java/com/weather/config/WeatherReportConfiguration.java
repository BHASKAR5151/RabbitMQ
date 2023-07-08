package com.weather.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherReportConfiguration {

    @Bean
    public RestTemplate RestTemplate(){
        RestTemplate RestTemplate = new RestTemplate();
        return RestTemplate;
    }

}
