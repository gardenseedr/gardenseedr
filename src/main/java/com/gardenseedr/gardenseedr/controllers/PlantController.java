package com.gardenseedr.gardenseedr.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gardenseedr.gardenseedr.models.POJOs.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;


@Controller
public class PlantController {
@Autowired
private RestTemplate restTemplate;

    public Weather getWeather() throws JsonProcessingException {
        String url = "https://openfarm.cc/api/v1/crops/544c88bd3432630002000000";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Weather weather = mapper.readValue(response.getBody(), Weather.class);
        return weather;
    }

}
