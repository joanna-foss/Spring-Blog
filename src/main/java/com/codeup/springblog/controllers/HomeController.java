package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String landing(Model model){
        model.addAttribute("title", "Home");
        return "home";
    }

    @GetMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }
}