package com.casestudy.foodtruck;


import com.casestudy.foodtruck.model.Item;
import com.casestudy.foodtruck.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ItemConfig {
    @Autowired
    private ItemService itemService;

    @PostConstruct
    public void setup() {
        itemService.create(new Item(1L, "Chocolate Frosted", "Classic cake donut topped with homemade chocolate icing", 1.00));
        itemService.create(new Item(2L, "Glazed and Confused", "A classic glazed donut so delicious it'll make you wonder why you didn't buy more", 1.00));
        itemService.create(new Item(3L, "Boston Cream", "This round, Bavarian cream-filled donut has chocolate frosting and will make you want to pahk your cah so you can stay and eat more!", 1.00));
    }
}
