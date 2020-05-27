package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;

import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class GardenController {

    private UserRepository userDao;
    private GardenRepository gardenRepo;

    public GardenController(GardenRepository gardenRepo, UserRepository userDao) {
        this.gardenRepo = gardenRepo;
        this.userDao = userDao;
    }

    // Create garden from dashboard button
    @PostMapping("/dashboard/{userId}")
    public String createGarden (@ModelAttribute Garden garden, @PathVariable long userId){
        LocalDate today = LocalDate.now();
        garden.setCreated(today);
        garden.setUser(userDao.getOne(userId));
        gardenRepo.save(garden);

        return "redirect:/garden/" + garden.getId();
    }

    // Go to already existing garden's page
    @GetMapping("/garden/{gardenId}")
    public String seeGarden(@PathVariable long gardenId, Model model){
        model.addAttribute("garden", gardenRepo.getOne(gardenId));
        return ("userGarden");
    }

    // Create a new garden and go to that page
    @GetMapping("/userGarden")
    public String createGarden(Model model){
        model.addAttribute("garden", new Garden());
        return ("userGarden");
    }

    @PostMapping("/userGarden")
    public String saveUser(@ModelAttribute Garden garden){
        gardenRepo.save(garden);
        return "userGarden";
    }

}
