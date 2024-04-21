package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreServiceInterface {
    List<Genre> getAllGenres();
    Optional<Genre> getGenreById(int id);
    int saveGenre(Genre genre);
    int deleteGenreById(int id);
}
