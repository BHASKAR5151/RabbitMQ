package com.weather.service;

import com.weather.model.WeatherReportResponse;

public interface WeatherReportService {

    WeatherReportResponse getWeatherReport(double latitude, double longitude);
}
