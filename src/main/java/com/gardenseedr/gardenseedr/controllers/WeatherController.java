package com.gardenseedr.gardenseedr.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

//@ComponentScan("com.spring.restapi.config")
@Controller
public class WeatherController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openWeatherToken}")
    private String openWeatherToken;

    @GetMapping("/weather")
    public String getWeather(Model model){
        String url = "https://api.openweathermap.org/data/2.5/weather?zip=78215,us&appid=" + openWeatherToken;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
        return "userDashboard";
    }






}
