package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Author;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Service.AuthorServiceInterface;
import com.sshproject.bookstore.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {


    @Autowired
    private AuthorServiceInterface authorService;

    @GetMapping("api/v1/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") int id) {
        Optional<Author> author = authorService.getAuthorById(id);
        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("api/v1/authors")
    public ResponseEntity<Integer> addAuthor(@RequestBody Author author) {
        int res = authorService.addAuthor(author);
        return ResponseEntity.ok(res);
    }

    @GetMapping("api/v1/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(authors);
        }
    }

    @DeleteMapping("api/v1/authors/{id}")
    public ResponseEntity<Integer> deleteAuthorById(@PathVariable("id") int id) {
        int res = authorService.deleteAuthorById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("api/v1/authors/{id}/books")
    public ResponseEntity<List<Book>> getAuthorBooks(@PathVariable("id") int id) {
        List<Book> books = authorService.getAuthorBooks(id);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(books);
        }
    }

}
