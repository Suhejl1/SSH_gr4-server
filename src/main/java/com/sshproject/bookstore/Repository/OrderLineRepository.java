package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    // JPA implements the create, read, update and delete methods
}
