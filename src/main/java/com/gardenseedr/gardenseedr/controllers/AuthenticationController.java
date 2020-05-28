package com.gardenseedr.gardenseedr.controllers;

import com.gardenseedr.gardenseedr.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "/login";
    }

    @GetMapping("/dashboard/success")
    public String returnLogin() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "redirect:/dashboard/" + user.getId();
    }


}


