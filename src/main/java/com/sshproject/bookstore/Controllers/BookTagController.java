package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.BookTag;
import com.sshproject.bookstore.Service.BookTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookTagController {

    @Autowired
    private BookTagService bookTagService;

    @GetMapping("api/v1/booktag/{tag}")
    public List<Book> getBooksByTag(@PathVariable("tag") String tag){
        List<Book> booksRes = bookTagService.getBooksByTag(tag);
        return booksRes;
    }

    @PostMapping("api/v1/booktag")
    public int addBookTag(@RequestBody BookTag bookTag){
        int res = bookTagService.addBookTag(bookTag);
        return res;
    }


}
