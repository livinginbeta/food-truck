package com.casestudy.foodtruck.controller;


import com.casestudy.foodtruck.model.CartItem;
import com.casestudy.foodtruck.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartItemController {
    private CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<CartItem> create(@RequestBody CartItem cartItemToBeCreated) {
        return new ResponseEntity<>(cartItemService.create(cartItemToBeCreated), HttpStatus.CREATED);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<CartItem>> readAll() {
        return new ResponseEntity<>(cartItemService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/read/{cartItemId}")
    public ResponseEntity<CartItem> readById(@PathVariable Long cartItemId) {
        return new ResponseEntity<>(cartItemService.readById(cartItemId), HttpStatus.OK);
    }

    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<CartItem> update(@PathVariable Long cartItemId, @RequestBody CartItem newData) {
        return new ResponseEntity<>(cartItemService.updateById(cartItemId, newData), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<CartItem> delete(@PathVariable Long cartItemId) {
        return new ResponseEntity<>(cartItemService.deleteById(cartItemId), HttpStatus.OK);
    }
























}
