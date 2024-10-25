package com.mihitha.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mihitha.backend.dto.ItemDto;
import com.mihitha.backend.entity.Item;

@Service
public interface ItemService {

    List<Item> getAllItems();
    Item createItem(ItemDto itemDto);
    Item getItemById(Long id);
    Item updateItem(Long id, Item item);
    Item deleteItem(Long id);
    List<Item> getItemsByCategory(Long id);
     
}
