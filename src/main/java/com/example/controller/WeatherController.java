package com.example.controller;

import com.example.model.request.WeatherRequest;
import com.example.model.response.WeatherResponse;
import com.example.service.api.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;

/**
 * @author Jiaguo Fang (pue626)
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService sampleService;

    @Autowired
    private ExecutorService executorService;

    @RequestMapping(value = "/weather", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult currentWeather(@RequestBody WeatherRequest weatherRequest) {
        DeferredResult deferredResult = new DeferredResult();
        Observable
                .from(weatherRequest.getLocations())
                .flatMap(location -> sampleService
                        .getWeather(location)
                        .subscribeOn(Schedulers.from(executorService)))
                .toList()
                .subscribe(response -> {
                    WeatherResponse weatherResponse = new WeatherResponse();
                    weatherResponse.setResponse(response);
                    deferredResult.setResult(weatherResponse);
                }, error -> {
                    System.out.println(error);
                    deferredResult.setErrorResult(error);
                });

        return deferredResult;
    }
}
