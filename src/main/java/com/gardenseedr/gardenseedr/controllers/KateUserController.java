package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;

@Controller
public class KateUserController {

    private UserRepository userDao;
    private GardenRepository gardenDao;

    public KateUserController(UserRepository userDao, GardenRepository gardenDao) { //change for actual UserController
        this.userDao = userDao;
        this.gardenDao = gardenDao;
    }

    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable long id, Model model){
        model.addAttribute("user", userDao.getOne(id));
//        model.addAttribute("garde)
        return "userDashboard";
    }

//    @PostMapping("/dashboard")
//    public String saveUser(@ModelAttribute User user){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }

}
