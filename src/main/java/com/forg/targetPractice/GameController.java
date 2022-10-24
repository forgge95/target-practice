package com.forg.targetPractice;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.forg.targetPractice.Entity.User.User;

@Controller
public class GameController {
    @GetMapping({"/game"})
    public String gameInitialisor(User user, Model model){
        model.addAttribute("user", user);
        return "game";
    }
}
