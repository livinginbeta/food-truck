package com.casestudy.foodtruck.repository;


import com.casestudy.foodtruck.model.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
