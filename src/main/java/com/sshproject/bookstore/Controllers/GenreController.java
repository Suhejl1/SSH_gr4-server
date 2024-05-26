package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Genre;
import com.sshproject.bookstore.Service.GenreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class
GenreController {
    @Autowired
    private GenreServiceInterface genreServiceInterface;
    @GetMapping("api/v1/genre/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") int id){
        Optional<Genre> genre = genreServiceInterface.getGenreById(id);
        return genre.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("api/v1/genre")
    public ResponseEntity<String> saveGenre(@RequestBody Genre genre){
        int result = genreServiceInterface.saveGenre(genre);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Genre saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save genre");
        }
    }
    @DeleteMapping("api/v1/genre/{id}")
    public ResponseEntity<String> deleteGenreById(@PathVariable("id") int id){
        int result = genreServiceInterface.deleteGenreById(id);
        if (result > 0) {
            return ResponseEntity.ok("Genre deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genre not found");
        }
    }

    @GetMapping("api/v1/genre")
    public ResponseEntity<List<Genre>> getAllGenres(){
        List<Genre> genres = genreServiceInterface.getAllGenres();
        if (genres.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(genres);
        }
    }

    //getGenreIdByGenre
    @GetMapping("api/v1/genre/name/{genreName}")
    public int getGenreIdByName(@PathVariable("genreName") String genreName){
        int result = genreServiceInterface.getGenreIdByName(genreName);
        if(result != -1){
            return result;
        }else{
            return -1;
        }
    }
}
