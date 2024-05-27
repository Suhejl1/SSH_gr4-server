package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.DTO.CartItemDTO;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Cart;
import com.sshproject.bookstore.Entity.Wishlist;
import com.sshproject.bookstore.Service.CartServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    @Autowired
    private CartServiceInterface cartService;


    @GetMapping("api/v1/cart/{userId}")
    public ResponseEntity<List<CartItemDTO>> getAllCartItems(@PathVariable int userId) {
        List<CartItemDTO> books = cartService.getAllCartItems(userId);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }


    @PutMapping("api/v1/cart/update/{userId}/{bookId}/{newQuantity}")
    public ResponseEntity<String> updateCartItem(@PathVariable int userId, @PathVariable int bookId, @PathVariable int newQuantity) {
        System.out.println("THis it the update controller");
        cartService.updateCartItem(userId, bookId, newQuantity);
        return ResponseEntity.ok("Item updated successfully");

    }


    @PostMapping("api/v1/cart")
    public ResponseEntity<String> addToCart(@RequestBody Cart cartItem) {
        cartService.addToCart(cartItem);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item added to cart successfully");
    }


    @DeleteMapping("api/v1/cart/{userId}/{bookId}")
    public ResponseEntity<String> deleteFromCart(@PathVariable int userId, @PathVariable int bookId) {
        cartService.deleteFromCart(userId,bookId);
        return ResponseEntity.ok("Item deleted from cart successfully");
    }

    @DeleteMapping("api/v1/cart/{userId}")
    public ResponseEntity<String> deleteAllItemsFromCart(@PathVariable int userId) {
        cartService.deleteAllItemsFromCart(userId);
        return ResponseEntity.ok("All items deleted form cart successfully");
    }
}
