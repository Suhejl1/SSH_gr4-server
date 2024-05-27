package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer>{

    List<Cart> findByCartId(int cartId);

    Optional<Cart> findByCartIdAndProductItemId(int cartItemId, int bookId);

    void deleteByCartId(int userId);

    void deleteAllByCartId(int cartId);
}
