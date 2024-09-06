package com.kevin.emazon.domain.spi;

import com.kevin.emazon.domain.model.Item;

import java.util.List;

public interface IItemPersistentPort {
    Item saveItem(Item item);
    List<Item> getItemsByCategoryName(String categoryName, String order);
    List<Item> getItemsByBrandName(String brandName, String order);
    List<Item> getItemsByName(String itemName, String order);

    boolean existById(Long id);
}
