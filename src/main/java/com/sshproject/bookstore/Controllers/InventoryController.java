package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Inventory;
import com.sshproject.bookstore.Service.InventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {
    @Autowired
    private InventoryServiceInterface serviceInterface;
    @GetMapping("api/v1/inventory")
    public ResponseEntity<List<Inventory>> getAll() {
        List<Inventory> inventoryList = serviceInterface.getAll();
        if (inventoryList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(inventoryList);
        }
    }

    @GetMapping("api/v1/inventory/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") int id) {
        Optional<Inventory> inventory = serviceInterface.getInventoryById(id);
        return inventory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("api/v1/inventory")
    public ResponseEntity<String> saveInventory(@RequestBody Inventory inventory) {
        int result = serviceInterface.saveInventory(inventory);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Inventory saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save inventory");
        }
    }

    @DeleteMapping("api/v1/inventory/{id}")
    public ResponseEntity<String> deleteInventoryById(@PathVariable("id") int id) {
        int result = serviceInterface.deleteInventoryById(id);
        if (result > 0) {
            return ResponseEntity.ok("Inventory deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inventory not found");
        }
    }
}
