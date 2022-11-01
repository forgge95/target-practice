package com.forg.targetPractice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forg.targetPractice.Entity.User.Model.User;
import com.forg.targetPractice.Entity.User.Model.UserScore;
import com.forg.targetPractice.Entity.User.Services.LoginValidation;
import com.forg.targetPractice.Entity.User.Services.UserRepository;

@Controller
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/userRegistration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/userRegistration")
    public String processRegister(User user) {
        userRepo.save(user);       
        return "registration_success";
    }
    @GetMapping("/highscores")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll().stream()
            .filter(x -> x.getHighscore()>0)
            .sorted(Comparator.comparing(User::getHighscore).reversed())
            .collect(Collectors.toList());
        model.addAttribute("listUsers", listUsers);
        
        return "highscores";
    }
    @GetMapping("/userLogin")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/userLogin")
    public String validateLoginProcess(User user, Model model){
        LoginValidation validator = new LoginValidation();
        if(validator.validate(user, userRepo)){
            return "game";
        }
        model.addAttribute("successfulLogin", false);
        return "login";
    }

    @PostMapping("/game/processHighscore")
    @ResponseStatus(value = HttpStatus.OK)
    public void processHighscore(@RequestBody String highscore) 
        throws JsonMappingException, JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        UserScore userScore = objectMapper.readValue(highscore, UserScore.class);
        
        System.out.println(userScore.getScore() + " : " + userScore.getId());
        userRepo.setHighscore(userScore.getScore() , userScore.getId());
    }

    @GetMapping({"/game"})
    public String gameInitialisor(User user, Model model){
        model.addAttribute("user", user);
        return "game";
    }
}
