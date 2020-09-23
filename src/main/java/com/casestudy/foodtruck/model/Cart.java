package com.casestudy.foodtruck.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @OneToMany
   // @ElementCollection
    private Set<CartItem> cartItems;


    public Cart(Long cartId, Set<CartItem> cartItems) {
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

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem itemToAddToCart) {
        getCartItems().add(itemToAddToCart);
    }
}