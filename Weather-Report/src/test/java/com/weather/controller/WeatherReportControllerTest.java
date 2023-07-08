//package com.weather.controller;
//
//import com.weather.model.WeatherReportResponse;
//import com.weather.service.WeatherReportService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class WeatherReportControllerTest {
//
//    @InjectMocks
//    WeatherReportController weatherReportController;
//
//    @Mock
//    private WeatherReportService weatherReportService;
//
//
//    //@Test
//    void testGetWeatherReport() {
//        WeatherReportResponse mockResponse = new WeatherReportResponse(/* provide necessary data */);
//        Mockito.when(weatherReportService.getWeatherReport(Mockito.anyDouble(), Mockito.anyDouble()))
//                .thenReturn(mockResponse);
//        ResponseEntity<WeatherReportResponse> responseEntity = weatherReportController.getWeatherReport(44.34, 10.99);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//    }
//
//
//}
