package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return num1 + " plus " + num2 + " = " + (num1 + num2);
    }

    @RequestMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        return num1 + " minus " + num2 + " = " + (num2 - num1);
    }

    @RequestMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        return num1 + " multiplied by " + num2 + " = " + (num1 * num2);
    }

    @RequestMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return num1 + " divided by " + num2 + " = " + (num1 / num2);
    }
}