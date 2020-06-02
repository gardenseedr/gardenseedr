package com.gardenseedr.gardenseedr.controllers;

//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.gardenseedr.gardenseedr.models.POJOs.Weather;
//import org.jboss.jandex.Main;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.client.RestTemplate;
//
////@ComponentScan("com.spring.restapi.config")
//@Controller
//public class WeatherController {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${openWeatherToken}")
//    private String openWeatherToken;
//
//    @GetMapping("/userDashboard")
//    public Weather getWeather() throws JsonProcessingException {
//        System.out.println(openWeatherToken);
//        String url = "https://api.openweathermap.org/data/2.5/weather?zip=78215,us&units=imperial&appid=" + openWeatherToken;
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        Weather weather = mapper.readValue(response.getBody(), Weather.class);
//        return weather;
//        model.addAttribute("weather", weather);
//        //try to add main functionality here
//        Main main = mapper.readValue(response.getBody(), Main.class);
//        model.addAttribute("main", main);
//        System.out.println(response.getBody());
//        return "userDashboard";
//    }
//
//
//
//
//
//
//
//
//}
