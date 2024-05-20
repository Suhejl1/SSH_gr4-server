package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Cart;
import com.sshproject.bookstore.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements CartServiceInterface {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getCartItems(int userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void addToCart(Cart cartItem) {
        cartRepository.save(cartItem);
    }

    @Override
    public void deleteFromCart(int userId, int bookId) {
        cartRepository.deleteByUserIdAndBookId(userId, bookId);
    }

    @Override
    public void clearCart(int userId) {
        cartRepository.deleteByUserId(userId);
    }

    @Override
    public void updateCartItem(int userId, int bookId, int quantity) {
        Cart cartItem = cartRepository.findByUserIdAndBookId(userId, bookId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartRepository.save(cartItem);
        }
    }
}
