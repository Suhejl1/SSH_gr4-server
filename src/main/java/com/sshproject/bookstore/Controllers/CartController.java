package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Cart;
import com.sshproject.bookstore.Service.CartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartServiceInterface cartService;

    @GetMapping("api/v1/cart")
    public List<Cart> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @PostMapping("api/v1/cart")
    public int addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @DeleteMapping("api/v1/cart/{cartItemId}")
    public void deleteFromCart(@PathVariable int cartItemId) {
        cartService.deleteFromCart(cartItemId);
    }
}
