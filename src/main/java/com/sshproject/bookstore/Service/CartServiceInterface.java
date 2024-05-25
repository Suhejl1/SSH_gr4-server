package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.DTO.CartItemDTO;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Cart;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartServiceInterface {
    List<CartItemDTO> getAllCartItems(int userId);

    int addToCart(Cart cart);
    void deleteFromCart(int cartItemId, int bookId);

    void deleteAllItemsFromCart(int userId);


    @Transactional
    void updateCartItem(int userId, int bookId, int newQuantity);

    @Transactional
    void incrementQuantity(int userId, int bookId);

    @Transactional
    void decrementQuantity(int userId, int bookId);
}
