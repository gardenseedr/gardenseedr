package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;

import com.gardenseedr.gardenseedr.models.Plant;
import com.gardenseedr.gardenseedr.models.Square;
import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.SquareRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class GardenController {
    private SquareRepository squareRepo;
    private UserRepository userDao;
    private GardenRepository gardenRepo;


    public GardenController(GardenRepository gardenRepo, UserRepository userDao, SquareRepository squareRepo) {
        this.squareRepo = squareRepo;
        this.gardenRepo = gardenRepo;
        this.userDao = userDao;
    }

    // Create blank garden from dashboard button
    // (the GetMapping for dashboard/{userId} is in UserController)

    @PostMapping("/dashboard/{userId}")
    public String createGarden(@ModelAttribute Garden newgarden, @PathVariable long userId) {
        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

        newgarden.setCreated(today);
        newgarden.setUser(userDao.getOne(userId));
        System.out.println(newgarden.getId());
        System.out.println(newgarden.getUser().getFirst_name());
        System.out.println(newgarden.getUser().getLast_name());
        System.out.println(newgarden.getGarden_name());

        gardenRepo.save(newgarden);


        return "redirect:/garden/" + newgarden.getId();
    }

    // Go to already existing garden's page
    @GetMapping("/garden/{gardenId}")
    public String seeGarden(@PathVariable long gardenId, Model model) {
//        model.addAttribute("viewSquare", squareRepo.getOne(squareId));// so user can view squares in the garden
        model.addAttribute("garden", gardenRepo.getOne(gardenId)); //so userGarden can display user's garden
        model.addAttribute("allTheSquares", gardenRepo.getOne(gardenId).getSquares()); //so userGarden can see garden's List<Square>
        model.addAttribute("newSquare", new Square()); // so user can make new square
        return ("userGarden");
    }

    // Name newly created garden
    @PostMapping("/garden/{gardenId}")
    public String nameGarden(@ModelAttribute Garden garden, @PathVariable long gardenId) {
            LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

            garden.setCreated(garden.getCreated());
            garden.setUpdated(today);

            gardenRepo.save(garden);

            return "redirect:/garden/" + gardenId;
    }

    // Add a square to the garden --------------------------- ADJUST THIS ONCE THERE'S A FORM TO CREATE A NEW SQUARE
    @PostMapping("/garden/addsquare/{gardenId}")
    public String addGardenSquare(@ModelAttribute Square newSquare, @PathVariable long gardenId) {
            LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

            newSquare.setGarden(gardenRepo.getOne(gardenId));
            newSquare.setPlant_date(today);

            return "redirect:/garden/" + gardenId;
    }

    // Delete garden
    @PostMapping("/garden/delete/{gardenId}")
    public String deleteGarden(@PathVariable long gardenId) {
            long userId = gardenRepo.getOne(gardenId).getUser().getId();
            gardenRepo.delete(gardenRepo.getOne(gardenId));

            return "redirect:/dashboard/" + userId;
    }
}
