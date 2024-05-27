package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopCartRepository extends JpaRepository<ShopCart, Integer> {

    ShopCart findByUserId(int userId);
}
