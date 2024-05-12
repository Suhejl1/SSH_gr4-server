package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findByOrderId(int id);
    // JPA implements the create, read, update and delete methods
}
