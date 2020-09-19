package com.casestudy.foodtruck.repository;

import com.casestudy.foodtruck.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
