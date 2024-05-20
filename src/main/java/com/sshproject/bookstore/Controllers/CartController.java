package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Cart;
import com.sshproject.bookstore.Service.CartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    @Autowired
    private CartServiceInterface cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable int userId) {
        System.out.println("A po punon ky controller");
        List<Cart> cartItems = cartService.getCartItems(userId);
        if (cartItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cartItems);
        }
    }

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestBody Cart cartItem) {
        cartService.addToCart(cartItem);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item added to cart successfully");
    }

    @DeleteMapping("/{userId}/{bookId}")
    public ResponseEntity<String> deleteFromCart(@PathVariable int userId, @PathVariable int bookId) {
        cartService.deleteFromCart(userId, bookId);
        return ResponseEntity.ok("Item deleted from cart successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> clearCart(@PathVariable int userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared successfully");
    }

    @PutMapping("/{userId}/{bookId}")
    public ResponseEntity<String> updateCartItem(@PathVariable int userId, @PathVariable int bookId, @RequestBody int quantity) {
        cartService.updateCartItem(userId, bookId, quantity);
        return ResponseEntity.ok("Cart item updated successfully");
    }
}
