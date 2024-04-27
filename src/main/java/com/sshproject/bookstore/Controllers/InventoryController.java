package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Inventory;
import com.sshproject.bookstore.Service.InventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {
    @Autowired
    private InventoryServiceInterface serviceInterface;
    @GetMapping("api/v1/inventory")
    public List<Inventory> getAll(){
        return serviceInterface.getAll();
    }

    @GetMapping("api/v1/inventory/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable("id") int id){
        Optional<Inventory> inventory = serviceInterface.getInventoryById(id);
        return inventory;
    }


    @PostMapping("api/v1/inventory")
    public int saveInventory(@RequestBody Inventory inventory){
        int result = serviceInterface.saveInventory(inventory);
        return result;
    }

    @DeleteMapping("api/v1/inventory/{id}")
    public int deleteInventoryByI(@PathVariable("id") int id){
        int result = serviceInterface.deleteInventoryById(id);
        return result;
    }
}
