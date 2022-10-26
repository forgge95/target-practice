package com.forg.targetPractice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.forg.targetPractice.Entity.User.User;
import com.forg.targetPractice.Entity.User.UserRepository;
import com.forg.targetPractice.Entity.User.Services.LoginValidation;

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
}
