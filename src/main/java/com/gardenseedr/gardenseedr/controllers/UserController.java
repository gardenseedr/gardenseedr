package com.gardenseedr.gardenseedr.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gardenseedr.gardenseedr.models.Garden;
import com.gardenseedr.gardenseedr.models.POJOs.Weather;
import com.gardenseedr.gardenseedr.models.Plant;
import com.gardenseedr.gardenseedr.models.User;
import com.gardenseedr.gardenseedr.repositories.GardenRepository;
import com.gardenseedr.gardenseedr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {
    private UserRepository userDao;
    private GardenRepository gardenDao;
    private PasswordEncoder passwordEncoder;
@Autowired
    private RestTemplate restTemplate;

@Value("${openWeatherToken}")
    private String openWeatherToken;


    public UserController(UserRepository userDao, GardenRepository gardenDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.gardenDao = gardenDao;
        this.passwordEncoder = passwordEncoder;
    }

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
            return "redirect:/login";
        }

    // User's dashboard page
    @GetMapping("/dashboard/{userId}")
    public String showDashboard(@PathVariable long userId, Model model) throws JsonProcessingException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDao.getOne(userId);

         int userZip = userDao.getOne(userId).getZipcode();

         List<Plant> plantsDisplayed = new ArrayList<>();
//         for loop through alltheGardens
//         nested loop to check against plantsDisplayed

        if (userId != user.getId() || user == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("user", userDao.getOne(userId));  // so dashboard can say "Hi user!"
            model.addAttribute("allTheGardens", userDao.getOne(userId).getGardens()); // so dashboard can see all user's gardens
            model.addAttribute("newGarden", new Garden()); // so dashboard can generate a new garden assigned to user
            model.addAttribute("weather", getWeather(userZip)); // so dashboard can see the 3 day forecast
            return "userDashboard";

        }

    }
                public Weather getWeather(int userZip) throws JsonProcessingException {
                    String url = "https://api.openweathermap.org/data/2.5/weather?zip=" + userZip + ",us&appid=" + openWeatherToken + "&units=imperial";
                    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
                    ObjectMapper mapper = new ObjectMapper();
                    Weather weather = mapper.readValue(response.getBody(), Weather.class);
                    return weather;
                }

    // About Us Page
    @GetMapping("/aboutus")
    public String aboutUs (Model model, Principal user){
        if (user != null){ // so the dashboard link will work if there's a user
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", userDao.getOne(loggedInUser.getId()));
        }
        return "aboutUs";
    }

    // Catalog Page
    @GetMapping("/catalog")
    public String catalog (Model model, Principal user){
        if (user != null){ // so the dashboard link will work if there's a user
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", userDao.getOne(loggedInUser.getId()));
        }
        return "catalog";
    }

    // User Profile Page
    @GetMapping("/profile/{userId}")
    public String viewUserProfile (@PathVariable long userId, Model model){
        model.addAttribute("user", userDao.getOne(userId));
        return "userProfile";
    }

    // Edit User Profile Page
    @GetMapping("/editprofile/{userId}")
    public String editUserProfile (@PathVariable long userId, Model model){
        model.addAttribute("user", userDao.getOne(userId));
        return "editUserProfile";
    }
        // Actually editing the Profile
        @PostMapping("/editprofile/{userId}")
        public String editingUserProfile (@PathVariable long userId, @ModelAttribute User user){
            // Editing profile
            if (user.getEmail().equals("")){
                user.setEmail(userDao.getOne(userId).getEmail());
            }
            if (user.getFirst_name().equals("")){
                user.setFirst_name(userDao.getOne(userId).getFirst_name());
            }
            if (user.getLast_name().equals("")){
                user.setLast_name(userDao.getOne(userId).getLast_name());
            }
            if (user.getPassword().equals("")){
                user.setPassword(userDao.getOne(userId).getPassword());
            }
                else{
                String hash = passwordEncoder.encode(user.getPassword());
                user.setPassword(hash);
                }
            userDao.save(user);
            return "redirect:/profile/" + userId;
        }

    // Deleting profile/account
    @PostMapping("/delete/profile/{userId}")
    public String deleteUserProfile (@PathVariable long userId) {
        userDao.delete(userDao.getOne(userId));
        return "redirect:/";
    }
}
