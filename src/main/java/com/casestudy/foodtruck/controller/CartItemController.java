package com.casestudy.foodtruck.controller;


import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.model.CartItem;
import com.casestudy.foodtruck.model.Item;
import com.casestudy.foodtruck.service.CartItemService;
import com.casestudy.foodtruck.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartItemController {
    private CartService cartService;
    private CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService, CartService cartService) {
        this.cartItemService = cartItemService;
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public ResponseEntity<CartItem> create(@RequestBody CartItem cartItemToBeCreated) {
        return new ResponseEntity<>(cartItemService.create(cartItemToBeCreated), HttpStatus.CREATED);
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/addtocart/{name}")  //removed cartId
    public ResponseEntity<Cart> addToCart(@PathVariable String name) {
        CartItem itemToAddToCart = cartItemService.readByName(name);
        Cart cartToReceiveItem = cartService.readById(1L);
        cartToReceiveItem.addToCart(itemToAddToCart);
        cartToReceiveItem = cartService.updateById(1L, cartToReceiveItem);
        return new ResponseEntity<>(cartToReceiveItem, HttpStatus.CREATED);
    }

    /*
    @PostMapping("/addtocart/{cartId}/{name}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long cartId, @PathVariable String name) {
        CartItem itemToAddToCart = cartItemService.readByName(name);
        Cart cartToReceiveItem = cartService.readById(cartId);
        cartToReceiveItem.addToCart(itemToAddToCart);
        cartToReceiveItem = cartService.updateById(cartId, cartToReceiveItem);
        return new ResponseEntity<>(cartToReceiveItem, HttpStatus.OK);
    }

     */


    @GetMapping("/read/all")
    public ResponseEntity<List<CartItem>> readAll() {
        return new ResponseEntity<>(cartItemService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/read/{cartItemId}")
    public ResponseEntity<CartItem> readById(@PathVariable Long cartItemId) {
        return new ResponseEntity<>(cartItemService.readById(cartItemId), HttpStatus.OK);
    }
/////////////////////////////////ADD BY ID...
    @PostMapping("/addtocart/id/{itemId}")
    public ResponseEntity<CartItem> addToCart(@RequestBody long itemId) {
        return new ResponseEntity<>(cartItemService.addToCart(itemId), HttpStatus.CREATED);
    }



        @PutMapping("/update/{cartItemId}")
    public ResponseEntity<CartItem> updateById(@PathVariable Long cartItemId, @RequestBody CartItem newData) {
        return new ResponseEntity<>(cartItemService.updateById(cartItemId, newData), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<CartItem> delete(@PathVariable Long cartItemId) {
        return new ResponseEntity<>(cartItemService.deleteById(cartItemId), HttpStatus.OK);
    }
























}
