package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq,Integer> {
}
