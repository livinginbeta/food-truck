package com.casestudy.foodtruck.service;

import com.casestudy.foodtruck.model.Item;
import com.casestudy.foodtruck.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService (ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item create(Item itemToBeCreated) {
        return itemRepository.save(itemToBeCreated);
    }

    public Item readById(Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    public Item readByName(String itemName) {
        return readAll()
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst()
                .get();
    }

    public List<Item> readAll() {
        List<Item> itemList = new ArrayList<>();
        for(Item item: itemRepository.findAll()) {
            itemList.add(item);
        }
        return itemList;
    }

    public Item updateById(Long itemId, Item newData) {
        Item itemInDatabase = readById(itemId);
        itemInDatabase.setItemId(newData.getItemId());
        itemInDatabase.setName(newData.getName());
        itemInDatabase.setDescription(newData.getDescription());
        itemInDatabase.setPrice(newData.getPrice());
        itemRepository.save(itemInDatabase);
        return itemInDatabase;
    }

    public Item delete(Item item) {
        itemRepository.delete(item);
        return item;
    }

    public Item deleteById(Long itemId) {
        return delete(readById(itemId));
    }
}