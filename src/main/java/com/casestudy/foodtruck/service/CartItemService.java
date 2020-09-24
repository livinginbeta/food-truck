package com.casestudy.foodtruck.service;


import com.casestudy.foodtruck.model.Cart;
import com.casestudy.foodtruck.model.CartItem;
import com.casestudy.foodtruck.model.Item;
import com.casestudy.foodtruck.repository.CartItemRepository;
import com.casestudy.foodtruck.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {
    private ItemService itemService;
    private CartItemRepository cartItemRepository;
    private ItemRepository itemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, ItemRepository itemRepository) {
        this.cartItemRepository = cartItemRepository;
        this.itemRepository = itemRepository;
    }


    public CartItem create(CartItem cartItemToBeCreated) {
        return cartItemRepository.save(cartItemToBeCreated);
    }

    public CartItem readById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).get();
    }

    public CartItem readByName(String itemName) {
        return readAll()
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst()
                .orElse(null);
    }

    ///ADD QUANTITY TO CART
    public CartItem addToCart(Long itemId) {
        String itemName = itemRepository.findById(itemId).get().getName();

        if (readByName(itemName) != null) {
            readByName(itemName).increment();
            CartItem cartItemToUpdate = readByName(itemName);
            updateById(cartItemToUpdate.getCartItemId(), cartItemToUpdate);
            return cartItemRepository.save(cartItemToUpdate);
        }
        CartItem newCartItem = create(new CartItem(null, itemRepository.findById(itemId).get(), 1));
        return cartItemRepository.save(newCartItem);
    }

    //////REMOVE QUANTITY FROM CART
    public CartItem removeFromCart(Long itemId) {
        String itemName = itemRepository.findById(itemId).get().getName();

        if(readByName(itemName).getQuantity() <= 0) {
            readByName(itemName).setQuantity(0);
            CartItem cartItemToUpdate = readByName(itemName);
            return cartItemRepository.save(cartItemToUpdate);
        }
        if (readByName(itemName) != null || readByName(itemName).getQuantity() >= 2) {
            readByName(itemName).decrement();
            CartItem cartItemToUpdate = readByName(itemName);
            updateById(cartItemToUpdate.getCartItemId(), cartItemToUpdate);
            return cartItemRepository.save(cartItemToUpdate);
        }
        if(readByName(itemName).getQuantity() <= 1) {
            CartItem cartItemToRemove = readByName(itemName);
            delete(cartItemToRemove);
            return cartItemToRemove;
        }
        return null;
    }
    
    public CartItem clearCart(Long itemId) {
        String itemName = itemRepository.findById(itemId).get().getName();
        CartItem cartToClear = readByName(itemName);
        cartToClear.setQuantity(0);
        return cartItemRepository.save(cartToClear);
    }

/*
    ///UPDATED CODE TO MODIFY QUANTITY
    public CartItem addToCart(Long itemId) {
        //    if(cartItemRepository.contains(itemRepository.findById(itemId))) {
        if(cartItemRepository.existsById(itemId)) {
            //           CartItem cartItemToUpdate = readByName(itemRepository.findById(itemId).stream()
            //                  .filter(item -> item.getItemId().equals(itemId).getName());
            CartItem cartItemToUpdate = readById(itemId);
            cartItemToUpdate.increment();
            return cartItemRepository.save(cartItemToUpdate);
            //return cartItemToUpdate;
        }

        CartItem newCartItem = create(new CartItem(null, itemRepository.findById(itemId).get(),1));
        return cartItemRepository.save(newCartItem);
    }

 */



   /* SAVE ORIGINAL
    public CartItem addToCart(Long itemId) {
        CartItem newCartItem = create(new CartItem(null, itemRepository.findById(itemId).get(),1));
        return cartItemRepository.save(newCartItem);

    }

    */


    public CartItem addByName(String itemName) {
        CartItem newCartItem = create(new CartItem(null, itemService.readByName(itemName), 1));
        return cartItemRepository.save(newCartItem);
    }


  /*  ////////////////////Also in HomeController
    public CartItem addToCart7(//Long cartId,
                             // String itemName
                              Long itemId) {
//        CartItem itemToAddToCart = readByName(itemName);
        CartItem itemToAddToCart = readById(itemId); ///////////////////-----
        CartService cartService = null;   /////////////////////////
        //      Cart cartToReceiveItem = cartService.readById(cartId);
        //      Long cartId=1L;
        Cart cartToReceiveItem = cartService.readById(1L);
        cartToReceiveItem.addToCart(itemToAddToCart);
        cartToReceiveItem = cartService.updateById(1L, cartToReceiveItem);
        return cartItemRepository.save(itemToAddToCart);
    }
    ////////////////////////////////////////USE ABOVE
   */



   /*
    // /Added---------
    public CartItem addToCart7(Long cartId,String itemName) {
        CartItem itemToAddToCart = readByName(itemName);
        CartService cartService = null;   /////////////////////////
        Cart cartToReceiveItem = cartService.readById(cartId);
        cartToReceiveItem.addToCart(itemToAddToCart);
        cartToReceiveItem = cartService.updateById(cartId, cartToReceiveItem);
        return itemToAddToCart;
    }
    */
//--------------------------------------------------

    public List<CartItem> readAll() {
        List<CartItem> cartItemList = new ArrayList<>();
        for (CartItem cartItem : cartItemRepository.findAll()) {
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