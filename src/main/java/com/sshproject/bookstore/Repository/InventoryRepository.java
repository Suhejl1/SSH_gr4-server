package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    //  Jpa functionalities

}
