package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollController {
    @GetMapping("/roll-dice")
    public String roll() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice/results")
    public String roll(@RequestParam(name = "n")@PathVariable String n, Model model) {
        int random = (int) Math.floor(Math.random() * 6) + 1;
        boolean guess = false;
        model.addAttribute("n", n);
        model.addAttribute("random", random);
        if(n.equals(Integer.toString(random))) {
            guess = true;
        }
        model.addAttribute("guess", guess);
        return "roll-dice";
    }
}