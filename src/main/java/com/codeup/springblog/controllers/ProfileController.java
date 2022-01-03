package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {
    @GetMapping("/profile/{username}")
    public String profileLoad(@PathVariable String username, Model model) {
        return "profile";
    }
}