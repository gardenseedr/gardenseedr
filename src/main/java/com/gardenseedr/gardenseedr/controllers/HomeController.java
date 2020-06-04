package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Controller
public class HomeController {
    private UserRepository userDao;
    private GardenRepository gardenDao;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openWeatherToken}")
    private String openWeatherToken;


    public HomeController(UserRepository userDao, GardenRepository gardenDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.gardenDao = gardenDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String landing(Model model, Principal user) {
        if (user != null){ // so the dashboard link will work if there's a user
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", userDao.getOne(loggedInUser.getId()));
        }
        return "index";
    }
}