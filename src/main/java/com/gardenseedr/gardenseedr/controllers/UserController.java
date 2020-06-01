package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;
import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class UserController {
    private UserRepository userDao;
    private GardenRepository gardenDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, GardenRepository gardenDao, PasswordEncoder passwordEncoder) { //change for actual UserController
        this.userDao = userDao;
        this.gardenDao = gardenDao;
        this.passwordEncoder = passwordEncoder;
    }

    //                                                  Things from AndyUserController
    // registration page
    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    // actually registering
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "/login";
    }

    //                                                  Things from KateUserController
    // User's dashboard page
    @GetMapping("/dashboard/{userId}")
    public String showDashboard(@PathVariable long userId, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userId != user.getId() || user == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("user", userDao.getOne(userId));  // so dashboard can say "Hi user!"
            model.addAttribute("allTheGardens", userDao.getOne(userId).getGardens()); // so dashboard can see all user's gardens
            model.addAttribute("newGarden", new Garden()); // so dashboard can generate a new garden assigned to user
            return "userDashboard";
        }
    }
}
