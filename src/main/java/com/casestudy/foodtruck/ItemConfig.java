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
        itemService.create(new Item(4L, "Cruller De Ville", "There are 101 reasons why this ring of fried sweet dough is the right choice.", 1.00));
        itemService.create(new Item(5L, "Ich Bin Ein Berliner", "There is no 'ick' in this jelly-filled pastry. We are convinced that in his historic speech JFK meant he was one of these.", 1.00));
        itemService.create(new Item(6L, "Taiyaki", "This traditional Japanese treat is made with waffle batter and filled with red bean paste and either custard or cheese. Cho oishii! (very delicious!)", 1.00));
        itemService.create(new Item(7L, "With Great Powder Comes Great Responsibiliy", "This super-powdered cake donut will make you feel like a hero.", 1.00));
        itemService.create(new Item(8L, "Old-Fashioned", "This classic is still around for a reason. Enjoy this sour cream cake donut while feeling sophisticated and mature. Monocle not included.", 1.00));
        itemService.setupAll();
        
    }
}
