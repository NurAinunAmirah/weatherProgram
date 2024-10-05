package com.example.WeatherVisualization.service;
import com.example.WeatherVisualization.model.WeatherResponse; // Adjust this based on your structure

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherVisualizationService {
    private final String API_KEY="4ecbbe89cb1ac31b60087538197693ca";
    private final String BASE_URL= "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";

    public WeatherResponse getWeather(String city){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(BASE_URL,WeatherResponse.class, city, API_KEY);
    }
}
