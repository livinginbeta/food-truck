package com.casestudy.foodtruck.controller;
import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.model.CartItem;
import com.casestudy.foodtruck.service.CartItemService;
import com.casestudy.foodtruck.service.CartService;
import com.casestudy.foodtruck.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ControllerAdvice ///Maybe.... ?
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
        model.addAttribute("cartItems", cartItemService.readAll());
        return "menu_items";
    }

    @GetMapping("/checkout")
    public String getAllCartItems(Model model) {
        model.addAttribute("items", itemService.readAll());
        model.addAttribute("cartItems", cartItemService.readAll());
        return "checkout";
    }
    /*    @RequestMapping(value="/addtocart/{cartId}/{itemName}", method={RequestMethod.POST, RequestMethod.GET})
        public String addToCart(Model model, @PathVariable Long cartId, String itemName) {
        //    model.addAttribute("cart", cartService.addToCart(cartId, itemName));
            model.addAttribute("cart", cart.getCartId());
            return "cart";
        }
     */
    ////////////////////Also in CartItemService
    //Split RequestMethods to avoid "Request method 'GET' not supported" despite using POST method
    @RequestMapping(value = "/addtocart/id/{itemId}", method = {RequestMethod.POST, RequestMethod.GET})
    public String addToCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.addToCart(itemId));
        return "redirect:/all"; //return "menu_items";   ///"cart"
    }
    @RequestMapping(value = "/removefromcart/id/{itemId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String removeFromCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.removeFromCart(itemId));
        return "redirect:/all"; //return "menu_items";   ///"cart"
    }
   
    @GetMapping("/clearcart/id/{itemId}")
    public String clearCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.clearCart(itemId));
        return "redirect:/all";     
    }
    
    ///SHOPPING CART VERSIONS
    //Split RequestMethods to avoid "Request method 'GET' not supported" despite using POST method
    @RequestMapping(value = "/addtocart/sc/{itemId}", method = {RequestMethod.POST, RequestMethod.GET})
    public String addToCheckoutCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.addToCart(itemId));
        return "redirect:/checkout"; //return "menu_items";   ///"cart"
    }
    @RequestMapping(value = "/removefromcart/sc/{itemId}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String removeFromCheckoutCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.removeFromCart(itemId));
        return "redirect:/checkout"; //return "menu_items";   ///"cart"
    }

    @GetMapping("/clearcart/sc/{itemId}")
    public String clearCheckoutCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.clearCart(itemId));
        return "redirect:/checkout";
    }



    ////////////////////////////////////////
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