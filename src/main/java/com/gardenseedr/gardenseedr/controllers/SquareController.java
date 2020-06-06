package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Garden;
import com.gardenseedr.gardenseedr.models.Note;
import com.gardenseedr.gardenseedr.models.Square;
import com.gardenseedr.gardenseedr.repositories.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class SquareController {
    private PlantRepository plantRepo;
    private GardenRepository gardenRepo;
    private UserRepository userDao;
    private SquareRepository squareRepo;
    private PasswordEncoder passwordEncoder;
    private NoteRepository noteRepo;

    public SquareController(GardenRepository gardenRepo, UserRepository userDao, PlantRepository plantRepo, SquareRepository squareRepo, PasswordEncoder passwordEncoder, NoteRepository noteRepo) {
        this.plantRepo = plantRepo;
        this.gardenRepo = gardenRepo;
        this.userDao = userDao;
        this.squareRepo = squareRepo;
        this.passwordEncoder = passwordEncoder;
        this.noteRepo = noteRepo;
    }


    // See the info page for an individual Square
    @GetMapping("/square/{squareId}") // squareId provided by href (squareRepo.getOne()/whatever)
    public String seeSquare(@PathVariable long squareId, Model model) {
        model.addAttribute("daysOld", Period.between(squareRepo.getOne(squareId).getPlant_date(),LocalDate.now()));
        model.addAttribute("user", userDao.getOne(gardenRepo.getOne(squareRepo.getOne(squareId).getGarden().getId()).getUser().getId()));
        model.addAttribute("garden", gardenRepo.getOne(squareRepo.getOne(squareId).getGarden().getId()));
        model.addAttribute("square", squareRepo.getOne(squareId));
        model.addAttribute("allTheNotes", squareRepo.getOne(squareId).getNotes()); // so page can display existing Notes
        model.addAttribute("newNote", new Note()); // so user can make new Note

        return "userSquarePage";
    }

        // Create new Note using the blank one sent from GetMapping("/square/{squareId}")
        @PostMapping("/square/{squareId}")
        public String createNote(@ModelAttribute Note newnote, @PathVariable long squareId) {
            LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

            newnote.setCreated(today);
            newnote.setSquare(squareRepo.getOne(squareId));

            noteRepo.save(newnote);

            return "redirect:/square/" + squareId;
        }

        // Delete a Note
        @PostMapping("/note/delete/{noteId}")
        public String deleteNote(@PathVariable long noteId) {
            long squareId = noteRepo.getOne(noteId).getSquare().getId();

            noteRepo.delete(noteRepo.getOne(noteId));

            return "redirect:/square/" + squareId;
        }

        // Water the individual square sent from GetMapping("/square/{squareId}")
        @PostMapping("/square/water/{squareId}")
        public String waterSquare(@ModelAttribute Square square, @PathVariable long squareId) {
            LocalDate today = LocalDate.now(); //gets today's date in yyyy-mm-dd format

            square.setLast_watered(today);

            squareRepo.save(square);

            return "redirect:/square/" + squareId;
        }

        // Delete individual square sent from GetMapping("/square/{squareId}")
        @PostMapping("/square/delete/{squareId}")
        public String deleteSquare(@PathVariable long squareId) {

            long gardenId = squareRepo.getOne(squareId).getGarden().getId();
            squareRepo.delete(squareRepo.getOne(squareId));

            return "redirect:/garden/" + gardenId;
        }
}
