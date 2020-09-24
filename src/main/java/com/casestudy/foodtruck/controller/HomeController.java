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
        return "menu_items";
    }

    @GetMapping("/shoppingcart")
    public String getAllCartItems(Model model) {
        model.addAttribute("items", cartItemService.readAll());
        return "cart";
    }


/*    @RequestMapping(value="/addtocart/{cartId}/{itemName}", method={RequestMethod.POST, RequestMethod.GET})
    public String addToCart(Model model, @PathVariable Long cartId, String itemName) {
    //    model.addAttribute("cart", cartService.addToCart(cartId, itemName));
        model.addAttribute("cart", cart.getCartId());
        return "cart";
    }

 */

    ////////////////////Also in CartItemService
//         //   @PostMapping("/addtocart/id/{itemId}")
    //Split RequestMethods to avoid "Request method 'GET' not supported" despite using POST method
    @RequestMapping(value="addtocart/id/{itemId}", method={RequestMethod.POST, RequestMethod.GET})
    public String addToCart(Model model, @PathVariable Long itemId) {
        model.addAttribute("cartItems", cartItemService.addToCart(itemId));
        return "redirect:/all"; //return "menu_items";   ///"cart"
    }



 //       CartItem itemToAddToCart = cartItemService.readById(itemId);
 //       CartService cartService = null;   /////////////////////////
  //  --    Cart cartToReceiveItem = cartService.readById(cartId);
  //  --    Long cartId=1L;
//        Cart cartToReceiveItem = cartService.readById(1L);
 //       cartToReceiveItem.addToCart(itemToAddToCart);
 //       cartToReceiveItem = cartService.updateById(1L, cartToReceiveItem);
//        return "cart";
//    }

    /////MEH......
// ///   @PostMapping("/addtocart/{itemName}")
//    @RequestMapping(value="addtocart/{itemName}", method={RequestMethod.POST, RequestMethod.GET})
//    public String addToCart(Model model, @PathVariable String itemName) {
//        model.addAttribute("cartItems", cartService.addByName(itemName));
//        return "cart";
//    }
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
