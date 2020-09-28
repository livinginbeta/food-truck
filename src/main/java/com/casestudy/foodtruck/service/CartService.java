package com.casestudy.foodtruck.service;

import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.model.CartItem;
import com.casestudy.foodtruck.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ItemService itemService;

    @Autowired
    CartService(CartRepository cartRepository, CartItemService cartItemService, ItemService itemService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.itemService = itemService;
    }

    public Cart create(Cart cartToBeCreated) {
        return cartRepository.save(cartToBeCreated);
    }

    public List<Cart> readAll() {
        List<Cart> cartList = new ArrayList<>();
        for (Cart cart : cartRepository.findAll()) {
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


    public Cart addToCart(Long cartId, String itemName) {
        Cart cartToAddTo = readById(cartId);
        CartItem itemInCart = cartToAddTo.getItemByName(itemName);
        CartItem itemInDb = cartItemService.readById(itemInCart.getCartItemId());
        if (cartToAddTo.contains(itemName)) {
            itemInDb.increment();
            cartItemService.updateById(itemInCart.getCartItemId(), itemInDb);
            updateById(cartToAddTo.getCartId(), cartToAddTo);
        }
        return null;
    }
}