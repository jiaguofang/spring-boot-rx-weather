package com.example.service.impl;

import com.example.model.response.LocationWeather;
import com.example.service.api.WeatherService;
import com.example.service.model.response.YahooWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.net.URI;
import java.net.URLEncoder;

/**
 * @author Jiaguo Fang (pue626)
 */
@Service
public class YahooWeatherService implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Observable<LocationWeather> getWeather(final String location) {
        return Observable.create(new Observable.OnSubscribe<LocationWeather>() {
            @Override
            public void call(Subscriber<? super LocationWeather> subscriber) {
                try {
                    String query = String.format("select item.condition.text from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", location);
                    String queryEncoded = URLEncoder.encode(query, "UTF-8");
                    String uri = String.format("http://query.yahooapis.com/v1/public/yql?q=%s&format=json", queryEncoded);
                    System.out.println(uri);
                    YahooWeatherResponse response = restTemplate.getForObject(new URI(uri),
                            YahooWeatherResponse.class);
                    LocationWeather locationWeather = new LocationWeather();
                    locationWeather.setLocation(location);
                    locationWeather.setWeather(response.getQuery().getResults().getChannel().getItem().getCondition().getText());
                    subscriber.onNext(locationWeather);
                    subscriber.onCompleted();
                } catch (Exception ex) {
                    subscriber.onError(ex);
                }
            }
        });
    }
}
