package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController
{

    @Autowired
    private BookServiceInterface bookService;

    @PostMapping("api/v1/book")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {
        int id = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added with ID: " + id);
    }

    @GetMapping("api/v1/book")
    public ResponseEntity<?> getBooks() {
        List<Book> response_books = bookService.getBooks();
        if (response_books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No books found");
        }
        return ResponseEntity.ok(response_books);
    }

    @DeleteMapping("api/v1/book")
    public ResponseEntity<String> deleteBook() {
        List<Integer> id_responses = bookService.deleteBooks();
        if (id_responses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No books deleted");
        }
        return ResponseEntity.ok("Deleted book IDs: " + id_responses);
    }

    @GetMapping("api/v1/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("api/v1/book/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable("id") int id, @RequestBody Book book) {
        String response = bookService.updateBook(id, book);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }


}
