package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    void deleteByBookIdAndUserId(int bookId, int userId);

    List<Wishlist> findByUserId(int userId);

    boolean existsByBookIdAndUserId(int bookId, int userId);

    void deleteByUserId(int userId);
    // primary functions for update, delete , read, create done by JPA
}
