package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
}
