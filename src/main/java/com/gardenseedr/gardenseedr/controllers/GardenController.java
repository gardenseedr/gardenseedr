package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;

import com.gardenseedr.gardenseedr.models.Square;
import com.gardenseedr.gardenseedr.repositories.PlantRepository;
import com.gardenseedr.gardenseedr.repositories.SquareRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;

import java.time.LocalDate;


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
        System.out.println(newgarden.getId());
        System.out.println(newgarden.getUser().getFirst_name());
        System.out.println(newgarden.getUser().getLast_name());
        System.out.println(newgarden.getGarden_name());

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
        model.addAttribute("user", userDao.getOne(gardenRepo.getOne(gardenId).getUser().getId())); //so the dashboard link on the nav works
        model.addAttribute("garden", gardenRepo.getOne(gardenId)); //so userGarden can display user's garden
        model.addAttribute("allTheSquares", gardenRepo.getOne(gardenId).getSquares()); //so userGarden can see garden's List<Square>
        model.addAttribute("newSquare", new Square()); // so user can make new square


        if (keyword == null) {
            model.addAttribute("allThePlants", plantRepo.findAll());
        } else {
            model.addAttribute("allThePlants", plantRepo.findByKeyword(keyword));
        }
        return "userGarden";
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
    @PostMapping("/garden/addSquare/{gardenId}")
    public String addGardenSquare(@ModelAttribute Square newSquare, @PathVariable long gardenId) {
        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

        newSquare.setGarden(gardenRepo.getOne(gardenId));
        newSquare.setPlant_date(today);

        squareRepo.save(newSquare);

        return "redirect:/garden/" + gardenId;
    }
    @PostMapping("/garden/addSquare1/{gardenId}")
    public String addGardenSquare1(@ModelAttribute Square newSquare, @PathVariable long gardenId) {
        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

        newSquare.setGarden(gardenRepo.getOne(gardenId));
        newSquare.setPlant_date(today);
        //last watered
        //api id and db id

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
