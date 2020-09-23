package com.casestudy.foodtruck.service;


import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private CartRepository cartRepository;

    @Autowired
    CartService (CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart create(Cart cartToBeCreated) {
        return cartRepository.save(cartToBeCreated);
    }


    public List<Cart> readAll() {
        List<Cart> cartList = new ArrayList<>();
        for(Cart cart: cartRepository.findAll()) {
            cartList.add(cart);
        }
        return cartList;
    }

    public Cart readById(Long cartId) {
        return cartRepository.findById(cartId).get();
    }

    public Cart updateById(Long cartId, Cart updatedData) {
        Cart cartInDb = readById(cartId);
        cartInDb.setCartId(updatedData.getCartId());
        cartInDb.setCartItems(updatedData.getCartItems());
        cartInDb = cartRepository.save(cartInDb);
        return cartInDb;
    }

    public Cart delete(Cart cart) {
        cartRepository.delete(cart);
        return cart;
    }

    public Cart deleteById(Long cartId) {
        return delete(readById(cartId));
    }
}