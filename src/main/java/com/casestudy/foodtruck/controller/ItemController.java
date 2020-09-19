package com.casestudy.foodtruck.controller;


import com.casestudy.foodtruck.model.Item;
import com.casestudy.foodtruck.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<Item> create(@RequestBody Item itemToBeCreated) {
        return new ResponseEntity<>(itemService.create(itemToBeCreated), HttpStatus.CREATED);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<Item>> readAll() {
        return new ResponseEntity<>(itemService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Item> readById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.readById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item newData) {
        return new ResponseEntity<>(itemService.updateById(id, newData), HttpStatus.OK);
        }


    @DeleteMapping("/delete/{id}")
        public ResponseEntity<Item> delete(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.deleteById(id), HttpStatus.OK);
        }
}
