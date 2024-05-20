package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Cart;

import java.util.List;

public interface CartServiceInterface {
    List<Cart> getCartItems(int userId);
    void addToCart(Cart cartItem);
    void deleteFromCart(int userId, int bookId);
    void clearCart(int userId);
    void updateCartItem(int userId, int bookId, int quantity);
}
