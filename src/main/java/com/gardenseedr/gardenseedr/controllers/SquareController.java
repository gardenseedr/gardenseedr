package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.Square;
import com.gardenseedr.gardenseedr.repositories.SquareRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SquareController {
    private SquareRepository squareDao;

    public SquareController(SquareRepository squareDao) {
        this.squareDao = squareDao;
    }

    @GetMapping("/garden")
    public String createSquare(Model model){
        model.addAttribute("square", new Square());
        return ("userGarden");
    }

    @PostMapping("/garden/{id}")
    public String saveSquare(@ModelAttribute Square square){
        squareDao.save(square);
        return ("/userGarden");
    }
}
