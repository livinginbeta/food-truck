package com.casestudy.foodtruck.service;


import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Cart persistedCart = cartRepository.save(cartToBeCreated);
        return persistedCart;
    }

    public List<Cart> readAll() {
        Iterable<Cart> cartIterable = cartRepository.findAll();
        List<Cart> cartList = new ArrayList<>();
        cartIterable.forEach(cartList::add);
        return cartList;
    }

    public Cart readById(Long cartId) {
        return cartRepository.findById(cartId).get();
    }

    public Cart updateById(Long cartId, Cart updatedData) {
        Cart cartInDb = readById(cartId);
        cartInDb.setCartId(updatedData.getCartId());
        cartInDb.setItemId(updatedData.getItemId());
        cartInDb.setQuantity(updatedData.getQuantity());
        cartInDb = cartRepository.save(cartInDb);
        return cartInDb;
    }

    public Cart deleteById(Long cartId) {
        Cart cartToBeDeleted = readById(cartId);
        cartRepository.delete(cartToBeDeleted);
        return cartToBeDeleted;
    }







}
