package com.weather.controller;

import com.weather.model.WeatherReportResponse;
import com.weather.service.WeatherReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherReportController {

    @Autowired
    WeatherReportService weatherReportService;

    @GetMapping("/get-report")
    public ResponseEntity<WeatherReportResponse> getWeatherReport(@RequestParam("lat") double latitude,
                                                                         @RequestParam("lon") double longitude) {
        log.info(">> Start WeatherReportController- getWeatherReport method");
        WeatherReportResponse weatherReportResponse = weatherReportService.getWeatherReport(latitude, longitude);
        log.info("<< End WeatherReportController- getWeatherReport method");
        return new ResponseEntity<>(weatherReportResponse, HttpStatus.OK);
    }
}
