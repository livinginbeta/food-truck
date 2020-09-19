package com.casestudy.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping//("/test")
    public String homepage() {
        System.out.println("Welcome!");
        return "test";

    }

}
