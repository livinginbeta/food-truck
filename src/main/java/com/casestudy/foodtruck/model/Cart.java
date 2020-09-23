package com.casestudy.foodtruck.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @OneToMany
    @ElementCollection
    private List<CartItem> cartItems;


    public Cart(Long cartId, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public Cart() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem itemToAddToCart) {
        getCartItems().add(itemToAddToCart);
    }

    public boolean contains(String itemName) {
        return getCartItems().stream()
                .filter(cartItem -> cartItem.getName().equals(itemName))
                .findAny()
                .isPresent();
    }

    public CartItem getItemByName(String itemName) {
        return getCartItems().stream()
                .filter(cartItem -> cartItem.getName().equals(itemName))
                .findFirst()
                .get();

    }

}