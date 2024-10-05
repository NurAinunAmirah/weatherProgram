package com.example.WeatherVisualization.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    private Main main;
    private String name;

    public static class Main{
        @JsonProperty("temp")
        private double temperature;

        public double getTemperature(){
            return temperature;
        }

        public void setTemperature(double temperature){
            this.temperature=temperature;
        }
    }

    public Main getMain() {
        return main; // Add this getter method
    }

    public void setMain(Main main) {
        this.main = main;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

}

