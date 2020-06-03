package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;
import com.gardenseedr.gardenseedr.models.Note;
import com.gardenseedr.gardenseedr.models.Square;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import com.gardenseedr.gardenseedr.repositories.PlantRepository;
import com.gardenseedr.gardenseedr.repositories.SquareRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class SquareController {
    private PlantRepository plantRepo;
    private GardenRepository gardenRepo;
    private UserRepository userDao;
    private SquareRepository squareRepo;
    private PasswordEncoder passwordEncoder;

    public SquareController(GardenRepository gardenRepo, UserRepository userDao, PlantRepository plantRepo, SquareRepository squareRepo, PasswordEncoder passwordEncoder) {
        this.plantRepo = plantRepo;
        this.gardenRepo = gardenRepo;
        this.userDao = userDao;
        this.squareRepo = squareRepo;
        this.passwordEncoder = passwordEncoder;
    }


    // Go to already existing garden's page
    @GetMapping("/square/{squareId}") // squareId provided by href (squareRepo.getOne()/whatever)
    public String seeSquare(@PathVariable long squareId, Model model, String keyword) {
        model.addAttribute("user", userDao.getOne(gardenRepo.getOne(squareRepo.getOne(squareId).getGarden().getId()).getUser().getId()));
        model.addAttribute("garden", gardenRepo.getOne(squareRepo.getOne(squareId).getGarden().getId()));
        model.addAttribute("allTheNotes", squareRepo.getOne(squareId).getNotes()); // so page can display existing Notes
        model.addAttribute("newNote", new Note()); // so user can make new Note

        return "userSquarePage";
    }





    // Create blank garden from dashboard button
    // (the GetMapping for dashboard/{userId} is in UserController)

//    @PostMapping("/square/{squareId}")
//    public String createGarden(@ModelAttribute Garden newgarden, @PathVariable long userId) {
//        LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format
//
//        newgarden.setCreated(today);
//        newgarden.setUser(userDao.getOne(userId));
//        System.out.println(newgarden.getId());
//        System.out.println(newgarden.getUser().getFirst_name());
//        System.out.println(newgarden.getUser().getLast_name());
//        System.out.println(newgarden.getGarden_name());
//
//        gardenRepo.save(newgarden);
//
//        return "redirect:/garden/" + newgarden.getId();
//    }

}
