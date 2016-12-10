package com.example.model.request;

import java.util.List;

/**
 * @author Jiaguo Fang (pue626)
 */
public class WeatherRequest {
    
    private List<String> locations;

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
