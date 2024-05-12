package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUserId(int userId);
    // CRUD(create, read, update and delete) functions automatically aded by JPA
}
