package com.forg.targetPractice;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/targets")
public class GameController {
    @GetMapping({"/","/game"})
    public String gameInitialisor(){
        return "game";
    }
}
