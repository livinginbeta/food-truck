package com.casestudy.foodtruck.controller;

import com.casestudy.foodtruck.service.CartItemService;
import com.casestudy.foodtruck.service.CartService;
import com.casestudy.foodtruck.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
@RequestMapping("/")
public class HomeController {
    //private Cart cart;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartService cartService;

    @GetMapping("/all")
    public String getAllItems(Model model) {
        model.addAttribute("items", itemService.readAll());
        model.addAttribute("cartItems", cartItemService.readAll()); ///allows display of items in cart
        return "menu_items";
    }

    @GetMapping("/{itemId}")
    public String getItemById(Model model, @PathVariable Long itemId) {
        model.addAttribute("item", itemService.readById(itemId));
        return "item_page";
    }

    @GetMapping("/checkout")
    public String getAllCartItems(Model model) {
        model.addAttribute("items", itemService.readAll());
        model.addAttribute("cartItems", cartItemService.readAll());
        return "checkout";
    }

    @GetMapping("/index")
    public String homepage(Model model) {
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    //Split RequestMethods to avoid "Request method 'GET' not supported" despite using POST method
    @RequestMapping(value = "/addtocart/id/{itemId}", method = {RequestMethod.POST, RequestMethod.GET})
    public String addToCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.addToCart(itemId));
        return "redirect:/all/#{itemId}";
    }

    @RequestMapping(value = "/removefromcart/id/{itemId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String removeFromCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.removeFromCart(itemId));
        return "redirect:/all/#{itemId}";
    }

    @GetMapping("/clearcart/id/{itemId}")
    public String clearCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.clearCart(itemId));
        return "redirect:/all/#{itemId}";
    }

    ///SHOPPING CART VERSIONS
    //Split RequestMethods to avoid "Request method 'GET' not supported" despite using POST method
    @RequestMapping(value = "/addtocart/sc/{itemId}", method = {RequestMethod.POST, RequestMethod.GET})
    public String addToCheckoutCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.addToCart(itemId));
        return "redirect:/checkout";
    }

    @RequestMapping(value = "/removefromcart/sc/{itemId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String removeFromCheckoutCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.removeFromCart(itemId));
        return "redirect:/checkout";
    }

    @GetMapping("/clearcart/sc/{itemId}")
    public String clearCheckoutCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.clearCart(itemId));
        return "redirect:/checkout";
    }

    ///DETAIL PAGE VERSIONS
    //Split RequestMethods to avoid "Request method 'GET' not supported" despite using POST method
    @RequestMapping(value = "/addtocart/{itemId}", method = {RequestMethod.POST, RequestMethod.GET})
    public String addToDetailCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.addToCart(itemId));
        return "redirect:/{itemId}";
    }

    @RequestMapping(value = "/removefromcart/{itemId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String removeFromDetailCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.removeFromCart(itemId));
        return "redirect:/{itemId}";
    }

    @GetMapping("/clearcart/{itemId}")
    public String clearDetailCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.clearCart(itemId));
        return "redirect:/{itemId}";
    }
}