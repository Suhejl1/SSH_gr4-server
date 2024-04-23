package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Cart;

import java.util.List;

public interface CartServiceInterface {
    List<Cart> getAllCartItems();

    int addToCart(Cart cart);
    void deleteFromCart(int cartItemId);
}
