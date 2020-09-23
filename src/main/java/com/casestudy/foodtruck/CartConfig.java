package com.casestudy.foodtruck;


import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CartConfig {

    @Autowired
    private CartService cartService;

    @PostConstruct
    public void setup() {
        cartService.create(new Cart());
    }
}
