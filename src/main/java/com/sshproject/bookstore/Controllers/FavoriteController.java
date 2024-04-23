package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Favorite;
import com.sshproject.bookstore.Service.FavoriteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteServiceInterface favoriteService;

    @GetMapping("api/v1/favorites")
    public List<Favorite> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }

    @PostMapping("api/v1/favorites")
    public int addToFavorites(@RequestBody Favorite favorite) {
        return favoriteService.addToFavorites(favorite);
    }

    @DeleteMapping("api/v1/favorites/{userId}")
    public void deleteFromFavorites(@PathVariable int userId) {
        favoriteService.deleteFromFavorites(userId);
    }
}
