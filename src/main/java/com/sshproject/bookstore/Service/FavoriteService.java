package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Favorite;
import com.sshproject.bookstore.Repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService implements FavoriteServiceInterface {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    @Override
    public int addToFavorites(Favorite favorite) {
        Favorite newFavorite = new Favorite(favorite.getUserId(), favorite.getBookId());
        favoriteRepository.save(newFavorite);
        return newFavorite.getUserId(); // Or you can return newFavorite.getId() if it's the user ID you want to return
    }

    @Override
    public void deleteFromFavorites(int userId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(userId);
        favoriteOptional.ifPresent(favoriteRepository::delete);
    }
}
