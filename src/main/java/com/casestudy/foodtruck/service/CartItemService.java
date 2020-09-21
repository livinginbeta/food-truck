package com.casestudy.foodtruck.service;


import com.casestudy.foodtruck.model.CartItem;
import com.casestudy.foodtruck.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {
    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem create(CartItem cartItemToBeCreated) {
        return cartItemRepository.save(cartItemToBeCreated);
    }

    public CartItem readById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).get();
    }

    public List<CartItem> readAll() {
        List<CartItem> cartItemList = new ArrayList<>();
        for(CartItem cartItem : cartItemRepository.findAll()) {
            cartItemList.add(cartItem);
        }
        return cartItemList;
    }

    public CartItem updateById(Long cartItemId, CartItem newData) {
        CartItem cartItemInDb = readById(cartItemId);
        cartItemInDb.setCartItemId(newData.getCartItemId());
        cartItemInDb.setItem(newData.getItem());
        cartItemInDb.setQuantity(newData.getQuantity());
        cartItemRepository.save(cartItemInDb);
        return cartItemInDb;
    }

    public CartItem delete(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
        return cartItem;
    }

    public CartItem deleteById(Long cartItemId) {
        return delete(readById(cartItemId));
    }
}