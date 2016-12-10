package com.example.model.response;

import java.util.List;

/**
 * @author Jiaguo Fang (pue626)
 */
public class WeatherResponse {
    
    private List<LocationWeather> response;

    public List<LocationWeather> getResponse() {
        return response;
    }

    public void setResponse(List<LocationWeather> response) {
        this.response = response;
    }
}
