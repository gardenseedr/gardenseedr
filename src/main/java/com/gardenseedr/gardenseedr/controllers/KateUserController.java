package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;
import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class KateUserController {

    private UserRepository userDao;
    private GardenRepository gardenDao;

    public KateUserController(UserRepository userDao, GardenRepository gardenDao) { //change for actual UserController
        this.userDao = userDao;
        this.gardenDao = gardenDao;
    }

    // User's dashboard page
    @GetMapping("/dashboard/{userId}")
    public String showDashboard(@PathVariable long userId, Model model){
        model.addAttribute("user", userDao.getOne(userId));  // so dashboard can say "Hi user!"
        model.addAttribute("allTheGardens", userDao.getOne(userId).getGardens()); // so dashboard can see all user's gardens
        model.addAttribute("newGarden", new Garden()); // so dashboard can generate a new garden assigned to user

        return "userDashboard";
    }

}
