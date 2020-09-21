package com.casestudy.foodtruck.controller;


import com.casestudy.foodtruck.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {



    @Autowired
    private ItemService itemService;


    @GetMapping("/all")
    public String getAllItems(Model model) {
        model.addAttribute("items", itemService.readAll());
        return "menu_items";
    }


    @GetMapping("/{itemId}")
    public String getItemById(Model model, @PathVariable Long itemId) {
        model.addAttribute("item", itemService.readById(itemId));
        return "item_page";
    }


    @GetMapping("/test")
    public String homepage() {
        System.out.println("Welcome!");
        return "test";

    }

}
