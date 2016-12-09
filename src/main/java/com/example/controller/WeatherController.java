package com.example.controller;

import com.example.model.response.LocationWeather;
import com.example.service.api.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaguo Fang (pue626)
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService sampleService;

    @RequestMapping(value = "/weather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult currentWeather() {
        final DeferredResult deferredResult = new DeferredResult();
        Observable<LocationWeather> observable1 = sampleService.getWeather("Fremont, CA").subscribeOn(Schedulers.io());
        Observable<LocationWeather> observable2 = sampleService.getWeather("San Jose, CA").subscribeOn(Schedulers.io());
        Observable.zip(observable1, observable2, new Func2<LocationWeather, LocationWeather, Map>() {
            @Override
            public Map call(LocationWeather yahooWeatherResponse, LocationWeather yahooWeatherResponse2) {
                HashMap<String, LocationWeather> map = new HashMap<>();
                map.put("1", yahooWeatherResponse);
                map.put("2", yahooWeatherResponse2);
                return map;
            }
        }).subscribe(new Subscriber<Map>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                deferredResult.setErrorResult(e);
            }

            @Override
            public void onNext(Map result) {
                deferredResult.setResult(result);
            }
        });

        return deferredResult;
    }
}
