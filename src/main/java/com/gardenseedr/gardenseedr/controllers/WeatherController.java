package com.gardenseedr.gardenseedr.controllers;
// for testing purposes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Value("${openweather.key}")
    private String openweatherKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{zipcode}")
    public
}
