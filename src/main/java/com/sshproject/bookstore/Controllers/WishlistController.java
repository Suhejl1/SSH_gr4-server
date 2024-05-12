package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Service.WishlistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishlistController {

    @Autowired
    private WishlistServiceInterface wishlistService;

    // Tested with postMan works!
    @PostMapping("api/v1/wishlists/{userId}/{bookId}")
    public ResponseEntity<String> addBookToWishlist(@PathVariable int bookId, @PathVariable int userId) {
        wishlistService.addBookToWishlist(bookId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added to wishlist successfully");
    }

    @DeleteMapping("api/v1/wishlists/{userId}/{bookId}")
    public ResponseEntity<String> removeBookFromWishlist(@PathVariable int userId, @PathVariable int bookId) {
        wishlistService.removeBookFromWishlist(bookId, userId);
        return ResponseEntity.ok("Book removed from wishlist successfully.");
    }

    @GetMapping("api/v1/wishlists/{userId}")
    public ResponseEntity<List<Book>> getBooksFromWishlist(@PathVariable int userId) {
        List<Book> books = wishlistService.getBooksFromWishlist(userId);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(books);
        }
    }

    @GetMapping("api/v1/wishlists/{userId}/{bookId}")
    public ResponseEntity<String> checkBookOnWishlist(@PathVariable int userId, @PathVariable int bookId) {
        boolean isBookOnWishlist = wishlistService.checkBookOnWishlist(bookId, userId);
        if (isBookOnWishlist) {
            return ResponseEntity.ok("Book is on wishlist.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book is not on wishlist.");
        }
    }

    @DeleteMapping("api/v1/wishlists/{userId}")
    public ResponseEntity<String> clearWishlist(@PathVariable int userId) {
        wishlistService.clearWishlist(userId);
        return ResponseEntity.ok("Wishlist cleared successfully.");
    }
}
