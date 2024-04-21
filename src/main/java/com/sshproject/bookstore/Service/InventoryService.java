package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Inventory;
import com.sshproject.bookstore.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService implements InventoryServiceInterface{
    @Autowired
    public InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAll(){
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> getInventoryById(int id){
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        if(inventoryOptional.isPresent()){
            return inventoryOptional;
        }
        return null;
    }

    @Override
    public int saveInventory(Inventory inventory){
        Inventory inventory1 = new Inventory(inventory.getQuantity(),
                inventory.getDate_added(), inventory.getDate_modified());
        inventoryRepository.save(inventory1);
        return inventory1.getId();
    }

    @Override
    public int deleteInventoryById(int id){
        Optional<Inventory> inventoryOptional = getInventoryById(id);
        if(inventoryOptional.isPresent()){
            inventoryRepository.deleteById(id);
            return id;
        }
        return -1;
    }

}
