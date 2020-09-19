package com.casestudy.foodtruck;


import com.casestudy.foodtruck.model.Item;
import com.casestudy.foodtruck.repository.ItemRepository;
import com.casestudy.foodtruck.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class ItemConfig {
    @Autowired
    private ItemRepository itemRepository;

    @Bean
    public ItemService itemBuilder() {
        return new ItemService(itemRepository);
    }

    @PostConstruct
    public void setup() {
                itemBuilder().create(new Item(1L,"California Burrito", "Carne asada, cheese, salsa fresca, guacamole, and french fries", 5.95));
                itemBuilder().create(new Item(2L, "Oyakodon", "literally \"parent-and-child donburi\", chicken (the parent), egg (the child), sliced scallion, and seasoned with soy sauce, mirin, and dashi", 6.95));
                itemBuilder().create(new Item(3L, "Unadon", "Fillets of grilled eel glazed with a sweetened soy-based sauce and caramelized over charcoal fire then served over steamed white rice", 8.95));
    }
}
