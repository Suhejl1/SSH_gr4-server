package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.BookTag;
import com.sshproject.bookstore.Service.BookTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookTagController {

    @Autowired
    private BookTagService bookTagService;

    @GetMapping("api/v1/booktag/{tag}")
    public ResponseEntity<List<Book>> getBooksByTag(@PathVariable("tag") String tag){
        List<Book> booksRes = bookTagService.getBooksByTag(tag);
        if (booksRes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(booksRes);
        }
    }

    @PostMapping("api/v1/booktag")
    public ResponseEntity<String> addBookTag(@RequestBody BookTag bookTag){
        int res = bookTagService.addBookTag(bookTag);
        if (res > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Book tag added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add book tag");
        }
    }


}
