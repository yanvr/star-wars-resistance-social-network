package com.letscode.starwarsresistancenetwork.services;

import com.letscode.starwarsresistancenetwork.exceptions.BusinessException;
import com.letscode.starwarsresistancenetwork.models.Item;
import com.letscode.starwarsresistancenetwork.models.Rebel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final RebelService rebelService;

    public void update(Long id, List<Item> removedItems, List<Item> addedItems) {
        Rebel rebel = rebelService.findById(id);

        List<Item> inventory = rebel.getInventory();

        removeItems(inventory, removedItems);
        addItems(inventory, addedItems);

        rebelService.save(rebel);
    }

    private void addItems(List<Item> inventory, List<Item> addedItems) {
        addedItems.forEach(addedItem -> inventory.forEach(item -> {
            if (addedItem.getDefinitions().equals(item.getDefinitions())) {
                item.setQuantity(item.getQuantity() + addedItem.getQuantity());
            } else {
                inventory.add(addedItem);
            }
        }));
    }

    private void removeItems(List<Item> inventory, List<Item> removedItems) {
        removedItems.forEach(removedItem -> inventory.forEach(item -> {
            if (removedItem.getDefinitions().equals(item.getDefinitions())) {
                if (removedItem.getQuantity() <= item.getQuantity()) {
                    item.setQuantity(item.getQuantity() - removedItem.getQuantity());
                } else {
                    throw new BusinessException("The quantity of points informed for this trade is invalid.");
                }
            }
        }));
    }
}

