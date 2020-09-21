package com.casestudy.foodtruck.model;

import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    private Item item;

    private Integer quantity;


    public CartItem(Long cartItemId, Item item, Integer quantity) {
        this.cartItemId = cartItemId;
        this.item = item;
        this.quantity = quantity;
    }

    public CartItem(){

    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
