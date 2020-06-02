package com.gardenseedr.gardenseedr.models.POJOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{

    //data.weather[0].description
    private String weatherDescription;

    //need to figure zip code out, hardcoding zip into url

    //data.main.temp
    private double currentTemp;
    private double lowTemp;
    private double highTemp;

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(double lowTemp) {
        this.lowTemp = lowTemp;
    }

    public double getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(double highTemp) {
        this.highTemp = highTemp;
    }

    @Bean
    public Weather weather() {
        return new Weather();
    }

    public Weather() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Weather(Weather weather) {
        // TODO Auto-generated constructor stub
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        setWeatherDescription((String) weather.get("description"));
    }

    @JsonProperty("main")
    public void setMain(Map<String, Double> main) {
        setCurrentTemp(main.get("temp"));
        setLowTemp(main.get("temp_min"));
        setHighTemp(main.get("temp_max"));


    }










}
