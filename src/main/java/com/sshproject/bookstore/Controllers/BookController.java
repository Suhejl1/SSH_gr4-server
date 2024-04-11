package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController
{

    @Autowired
    private BookServiceInterface bookService;

    @PostMapping("api/v1/book")
    public int saveBook(@RequestBody Book book){
        int id = bookService.addBook(book);
        return id;
    }

    @GetMapping("api/v1/book")
    public List<Book> getBooks(){
        List<Book> response_books;
        response_books = bookService.getBooks();
        return response_books;
    }

    @DeleteMapping("api/v1/book")
    public List<Integer> deleteBook(){
        List<Integer> id_responses  = bookService.deleteBooks();
        return id_responses;
    }

    @GetMapping("api/v1/book/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id){
        Optional<Book> book = bookService.getBookById(id);
        return book;
    }
    @PutMapping("api/v1/book/{id}")
    public String updateBookById(int id, @RequestBody Book book){
        String response = bookService.updateBook(id, book);
        return response;
    }


}
