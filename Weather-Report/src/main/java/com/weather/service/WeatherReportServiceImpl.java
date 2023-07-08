package com.weather.service;

import com.weather.model.WeatherReportResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherReportServiceImpl implements WeatherReportService {

    @Value("${open.api.key}")
    String apiKey;

    @Value("${open.api.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherReportResponse getWeatherReport(double latitude, double longitude) {
        log.info(">> Start WeatherReportServiceImpl - getWeatherReport method");
        String apiUrl = url+"lat={latitude}&lon={longitude}&appid={apiKey}";
        ResponseEntity<WeatherReportResponse> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, WeatherReportResponse.class, latitude, longitude, apiKey);
        log.info("<< End WeatherReportServiceImpl - getWeatherReport method");
        return response.getBody();
    }
}
