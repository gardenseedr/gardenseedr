package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GardenController {
    private GardenRepository gardenRepo;

    public GardenController(GardenRepository gardenRepo) {
        this.gardenRepo = gardenRepo;
    }

    @GetMapping("userGarden")
    public String createGarden(Model model){
        model.addAttribute("garden", new Garden());
        return ("userGarden");
    }

    @PostMapping("userGarden")
    public String saveUser(@ModelAttribute Garden garden){
        gardenRepo.save(garden);
        return "userGarden";
    }

}
