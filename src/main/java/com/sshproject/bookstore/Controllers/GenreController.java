package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Genre;
import com.sshproject.bookstore.Service.GenreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GenreController {
    @Autowired
    private GenreServiceInterface genreServiceInterface;
    @GetMapping("api/v1/genre/{id}")
    public Optional<Genre> getGenreById(@PathVariable("id") int id){
        Optional<Genre> genre = genreServiceInterface.getGenreById(id);
        return genre;
    }


    @PostMapping("api/v1/genre")
    public int saveGenre(@RequestBody Genre genre){
        int result = genreServiceInterface.saveGenre(genre);
        return result;
    }
    @DeleteMapping("api/v1/genre/{id}")
    public int deleteGenreById(@PathVariable("id") int id){
        int result = genreServiceInterface.deleteGenreById(id);
        return result;
    }

    @GetMapping("api/v1/genre")
    public List<Genre> getAllGenres(){
        return genreServiceInterface.getAllGenres();
    }
}
