package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryServiceInterface {
    List<Inventory> getAll();
    Optional<Inventory> getInventoryById(int id);
    int saveInventory(Inventory inventory);
    int deleteInventoryById(int id);
}
