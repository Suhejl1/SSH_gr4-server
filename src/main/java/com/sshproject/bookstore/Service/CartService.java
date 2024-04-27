package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Cart;
import com.sshproject.bookstore.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements CartServiceInterface {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCartItems() {
        List<Cart> allCartItems = cartRepository.findAll();
        return allCartItems;
    }

    @Override
    public int addToCart(Cart cart) {
        Cart newCartItem = new Cart(cart.getCart_id(), cart.getProduct_item_id(), cart.getQuantity());
        cartRepository.save(newCartItem);
        return newCartItem.getId();
    }
    @Override
    public void deleteFromCart(int cartItemId) {
        Optional<Cart> cartItemOptional = cartRepository.findById(cartItemId);
        cartItemOptional.ifPresent(cartRepository::delete);
    }
}
