package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;

import com.gardenseedr.gardenseedr.models.Square;
import com.gardenseedr.gardenseedr.repositories.PlantRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import com.gardenseedr.gardenseedr.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
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


    public GardenController(GardenRepository gardenRepo, UserRepository userDao, PlantRepository plantRepo) {
        this.plantRepo = plantRepo;
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

        gardenRepo.save(newgarden);


        return "redirect:/garden/" + newgarden.getId();
    }

    // Go to already existing garden's page
    @GetMapping("/garden/{gardenId}")
    public String seeGarden(@PathVariable long gardenId, Model model) {
        model.addAttribute("garden", gardenRepo.getOne(gardenId)); //so userGarden can display user's garden
        model.addAttribute("allTheSquares", gardenRepo.getOne(gardenId).getSquares()); //so userGarden can see garden's List<Square>
        model.addAttribute("newSquare", new Square()); // so user can make new square
        model.addAttribute("allThePlants", plantRepo.getAllPlants());
        return ("userGarden");
    }


    // Name newly created garden
    @PostMapping("/garden/{gardenId}")
    public String alterTheGarden(@ModelAttribute Garden garden, @ModelAttribute Square newSquare, @PathVariable long gardenId) {
        // Delete the garden
        if (garden.getGarden_name() == null) { // only the delete form in userGarden.html resets the name to null
            long userId = garden.getUser().getId();
            gardenRepo.delete(garden);

            return "redirect:/dashboard/" + userId;
        }
        // Add a square to the garden ------ ADD THIS ONCE THERE'S A FORM TO CREATE A NEW SQUARE
//            else if(){
//                LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format
//
//                newSquare.setGarden(gardenRepo.getOne(gardenId));
//                newSquare.setPlant_date(today);
//
//                return "redirect:/garden/" + gardenId;
//            }
        // Name the garden
        else {
            LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format


            garden.setCreated(garden.getCreated());
            garden.setUpdated(today);

            gardenRepo.save(garden);

            return "redirect:/garden/" + gardenId;
        }
    }
}
