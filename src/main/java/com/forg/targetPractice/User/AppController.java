package com.forg.targetPractice.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());
     
    return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {    
    userRepo.save(user);
     
    return "register_success";
    }
    @GetMapping("/users")
    public String listUsers(Model model) {
    List<User> listUsers = userRepo.findAll();
    model.addAttribute("listUsers", listUsers);
     
    return "users";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
    List<User> listUsers = userRepo.findAll();
    User passedUser = (User) model.getAttribute("user");
    if(passedUser!=null&&passedUser.getEmail()!=null && passedUser.getPassword()!=null){
        return "login";
    }
    for (User user : listUsers) {
        if(passedUser.getEmail().equals(user.getEmail()) && passedUser.getPassword().equals(user.getPassword())){
            return "users";
        }
    }
    return "login";
    }
}