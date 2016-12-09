package com.example.service.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Jiaguo Fang (pue626)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class YahooWeatherResponse {

    public YahooWeatherResponse() {
    }

    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "YahooWeatherResponse{" +
                "query=" + query +
                '}';
    }
}
