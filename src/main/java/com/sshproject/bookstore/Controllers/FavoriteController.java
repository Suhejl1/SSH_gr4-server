package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Favorite;
import com.sshproject.bookstore.Service.FavoriteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteServiceInterface favoriteService;

    @GetMapping("api/v1/favorites")
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        List<Favorite> favorites = favoriteService.getAllFavorites();
        if (favorites.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(favorites);
        }
    }

    @PostMapping("api/v1/favorites")
    public ResponseEntity<String> addToFavorites(@RequestBody Favorite favorite) {
        int result = favoriteService.addToFavorites(favorite);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Favorite added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add favorite");
        }
    }

    @DeleteMapping("api/v1/favorites/{userId}")
    public ResponseEntity<String> deleteFromFavorites(@PathVariable int userId) {
        favoriteService.deleteFromFavorites(userId);
        return ResponseEntity.ok("Favorite deleted successfully");
    }
}
