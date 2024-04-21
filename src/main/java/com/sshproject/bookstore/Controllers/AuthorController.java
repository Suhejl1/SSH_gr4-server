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
    @GetMapping("api/v1/author/{id}")
    public Optional<Author> getAuthorById(@PathVariable("id") int id){
        Optional<Author> author = authorService.getAuthorById(id);
        return author;
    }

    @PostMapping("api/v1/author")
    public int addAuthor(@RequestBody Author author){
        int res = authorService.addAuthor(author);
        return res;
    }

    @GetMapping("api/v1/author")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @DeleteMapping("api/v1/author/{id}")
    public int deleteAuthorById(@PathVariable("id") int id){
        int res = authorService.deleteAuthorById(id);
        return res;
    }
}
