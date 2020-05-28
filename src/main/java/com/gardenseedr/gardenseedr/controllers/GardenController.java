package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;

import com.gardenseedr.gardenseedr.models.Plant;
import com.gardenseedr.gardenseedr.models.Square;
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
import java.util.List;

@Controller
public class GardenController {

    private UserRepository userDao;
    private GardenRepository gardenRepo;

    public GardenController(GardenRepository gardenRepo, UserRepository userDao) {
        this.gardenRepo = gardenRepo;
        this.userDao = userDao;
    }

    // Create blank garden from dashboard button
    // (the GetMapping for dashboard/{userId} is in UserController)
    @PostMapping("/dashboard/{userId}")
    public String createGarden (@ModelAttribute Garden newgarden, @PathVariable long userId){
        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

        newgarden.setCreated(today);
        newgarden.setUser(userDao.getOne(userId));
        gardenRepo.save(newgarden);

        return "redirect:/garden/" + newgarden.getId();
    }

    // Go to already existing garden's page
    @GetMapping("/garden/{gardenId}")
    public String seeGarden(@PathVariable long gardenId, Model model){
        model.addAttribute("garden", gardenRepo.getOne(gardenId)); //so userGarden can display user's garden
        model.addAttribute("allTheSquares", gardenRepo.getOne(gardenId).getSquares()); //so userGarden can see garden's List<Square>
        model.addAttribute("newSquare", new Square()); // so user can make new square

        return ("userGarden");
    }

    // Add Squares to existing garden
    @PostMapping("/garden/{gardenId}")
    public String addSquares(@ModelAttribute Square newSquare, @PathVariable long gardenId){
        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

        newSquare.setGarden(gardenRepo.getOne(gardenId));
        newSquare.setPlant_date(today);

        return "redirect:/garden/" + gardenId;
    }
}
