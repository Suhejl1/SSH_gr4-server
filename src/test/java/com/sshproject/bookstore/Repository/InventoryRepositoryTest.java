package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class InventoryRepositoryTest {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    public void testFindById() {
        // Arrange
        LocalDate now = LocalDate.now();
        Inventory inventory = new Inventory(100, now, now);
        Inventory savedInventory = inventoryRepository.save(inventory);

        // Act
        Optional<Inventory> foundInventory = inventoryRepository.findById(savedInventory.getId());

        // Assert
        assertThat(foundInventory).isPresent();
        assertThat(foundInventory.get().getQuantity()).isEqualTo(100);
        assertThat(foundInventory.get().getDateAdded()).isEqualTo(now);
        assertThat(foundInventory.get().getDateModified()).isEqualTo(now);
    }
}
