package com.casestudy.foodtruck.controller;


import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public ResponseEntity<Cart> create(Cart cartToBeCreated){
        return new ResponseEntity<>(cartService.create(cartToBeCreated), HttpStatus.CREATED);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> readById(@PathVariable Long cartId) {
       return new ResponseEntity<>(cartService.readById(cartId), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cart>> readAll() {
        return new ResponseEntity<>(cartService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/{cartId")
    public ResponseEntity<Cart> updateById(@PathVariable Long cartId, @RequestBody Cart newData) {
        return new ResponseEntity<>(cartService.updateById(cartId, newData), HttpStatus.OK);
    }

    @DeleteMapping("/{cartId")
    public ResponseEntity<Cart> deleteById(@PathVariable Long cartId) {
        return new ResponseEntity<>(cartService.deleteById(cartId), HttpStatus.OK);
    }

}
