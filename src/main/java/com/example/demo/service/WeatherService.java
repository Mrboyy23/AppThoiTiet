package com.example.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String API_KEY = "d598f341763c0712df9592b8170e269e"; // Thay bằng API Key của bạn
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Map<String, Object> getWeatherByCity(String city) {
        String url = BASE_URL + "weather?q=" + city + "&appid=" + API_KEY;
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getForecastByCity(String city) {
        String url = BASE_URL + "forecast?q=" + city + "&appid=" + API_KEY;
        return restTemplate.getForObject(url, Map.class);
    }
}
