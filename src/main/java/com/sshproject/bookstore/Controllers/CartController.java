package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Cart;
import com.sshproject.bookstore.Service.CartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartServiceInterface cartService;

    @GetMapping("api/v1/cart")
    public ResponseEntity<List<Cart>> getAllCartItems() {
        List<Cart> cartItems = cartService.getAllCartItems();
        if (cartItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cartItems);
        }
    }

    @PostMapping("api/v1/cart")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart) {
        int cartItemId = cartService.addToCart(cart);
        if (cartItemId > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Item added to cart successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add item to cart");
        }
    }

    @DeleteMapping("api/v1/cart/{cartItemId}")
    public ResponseEntity<String> deleteFromCart(@PathVariable int cartItemId) {
        cartService.deleteFromCart(cartItemId);
        return ResponseEntity.ok("Item deleted from cart successfully");
    }
}
