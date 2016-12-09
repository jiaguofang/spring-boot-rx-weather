package com.example.service.api;

import com.example.model.response.LocationWeather;
import rx.Observable;

/**
 * @author Jiaguo Fang (pue626)
 */
public interface WeatherService {
    
    Observable<LocationWeather> getWeather(String location);
}
