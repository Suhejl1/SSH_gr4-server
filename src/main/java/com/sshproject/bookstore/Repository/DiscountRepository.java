package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {
    Discount findByDiscountCode(String discountCode);
    // Discount repository
}
