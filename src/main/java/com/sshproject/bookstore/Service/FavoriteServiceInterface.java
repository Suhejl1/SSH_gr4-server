package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Favorite;

import java.util.List;

public interface FavoriteServiceInterface {
    List<Favorite> getAllFavorites();

    int addToFavorites(Favorite favorite);
    void deleteFromFavorites(int userId);
}
