package com.example.WeatherVisualization.controller;
import com.example.WeatherVisualization.model.WeatherResponse;
import com.example.WeatherVisualization.service.WeatherVisualizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    private final WeatherVisualizationService weatherVisualizationService;

    public WeatherController(WeatherVisualizationService weatherVisualizationService){
        this.weatherVisualizationService=weatherVisualizationService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam(required = false) String city, Model model) {
        if (city == null || city.isEmpty()) {
            model.addAttribute("error", "City parameter is required.");
            return "error"; // Return an error view or handle it as you wish
        }
        WeatherResponse weatherResponse = weatherVisualizationService.getWeather(city);
        model.addAttribute("city", weatherResponse.getName());
        model.addAttribute("temperature", weatherResponse.getMain().getTemperature());
        return "weather";
    }

}
