package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;

import com.gardenseedr.gardenseedr.models.Square;
import com.gardenseedr.gardenseedr.repositories.PlantRepository;
import com.gardenseedr.gardenseedr.repositories.SquareRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import com.gardenseedr.gardenseedr.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Controller
public class GardenController {
    private PlantRepository plantRepo;
    private UserRepository userDao;
    private GardenRepository gardenRepo;
    private SquareRepository squareRepo;


    public GardenController(GardenRepository gardenRepo, UserRepository userDao, PlantRepository plantRepo, SquareRepository squareRepo) {
        this.plantRepo = plantRepo;
        this.gardenRepo = gardenRepo;
        this.userDao = userDao;
        this.squareRepo = squareRepo;
    }

    // Create blank garden from dashboard button
    // (the GetMapping for dashboard/{userId} is in UserController)
    @PostMapping("/dashboard/{userId}")
    public String createGarden(@ModelAttribute Garden newgarden, @PathVariable long userId) {
        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

        newgarden.setCreated(today);
        newgarden.setUser(userDao.getOne(userId));

        gardenRepo.save(newgarden);

        return "redirect:/garden/" + newgarden.getId();
    }


    // This will be where the SEARCH function resides... eventually.
    @GetMapping("/search")
    public String findPlant(@PathVariable long gardenId, Model model, String keyword) {
        return "userGarden";
    }

    // Go to already existing garden's page
    @GetMapping("/garden/{gardenId}")
    public String seeGarden(@PathVariable long gardenId, Model model, String keyword) {
//        model.addAttribute("today", Period.between(squareRepo.getOne(squareId).getPlant_date(),LocalDate.now()));
        model.addAttribute("user", userDao.getOne(gardenRepo.getOne(gardenId).getUser().getId())); //so the dashboard link on the nav works
        model.addAttribute("garden", gardenRepo.getOne(gardenId)); //so userGarden can display user's garden
        model.addAttribute("allTheSquares", gardenRepo.getOne(gardenId).getSquares()); //so userGarden can see garden's List<Square>
        model.addAttribute("newSquare", new Square()); // so user can make new square
        model.addAttribute("viewSquare", squareRepo);

        //the date for the comparator will use
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = simpleDateFormat.format(date);
        model.addAttribute("standardDate", stringDate);

        if (keyword == null) {
            model.addAttribute("allThePlants", plantRepo.findAll());
        } else {
            model.addAttribute("allThePlants", plantRepo.findByKeyword(keyword));
        }


        return "userGarden";
    }


    // Name newly created garden
    @PostMapping("/garden/{gardenId}")
    public String nameGarden(@RequestParam String garden_name, @PathVariable long gardenId) {

        Garden garden = gardenRepo.getOne(gardenId);
            garden.setGarden_name(garden_name);

        gardenRepo.save(garden);

        return "redirect:/garden/" + gardenId;
    }

    // Add a square to the garden --------------------------- ADJUST THIS ONCE THERE'S A FORM TO CREATE A NEW SQUARE
    @PostMapping("/garden/addSquare/{gardenId}")
    public String addGardenSquare(@RequestParam(name = "plant-id") long plantId, @ModelAttribute Square newSquare, @PathVariable long gardenId) {
        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format
        newSquare.setPlant(plantRepo.getOne(plantId));
        newSquare.setGarden(gardenRepo.getOne(gardenId));
        newSquare.setLast_watered(today);
        newSquare.setPlant_date(today);

        squareRepo.save(newSquare);

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
