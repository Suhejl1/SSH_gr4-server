package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.DTO.BookRequestDTO;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookServiceInterface bookService;

    @PostMapping("/add")
    public ResponseEntity<String> saveBook(@RequestBody BookRequestDTO bookRequestDTO) {
        // Attempt to add the book
        int id = bookService.addBook(bookRequestDTO);
        System.out.println(id);

        if (id != -1) {
            // Book added successfully
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
        } else {
            // Book already exists
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Book already exists");
        }
    }

    @GetMapping
    public ResponseEntity<?> getBooks() {
        List<Book> responseBooks = bookService.getBooks();
        if (responseBooks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No books found");
        }
        return ResponseEntity.ok(responseBooks);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook() {
        List<Integer> idResponses = bookService.deleteBooks();
        if (idResponses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No books deleted");
        }
        return ResponseEntity.ok("Deleted book IDs: " + idResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable("id") int id, @RequestBody Book updatedBook) {
        String response = bookService.updateBook(id, updatedBook);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }

//    @GetMapping("/genre/{genreId}")
//    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable int genreId) {
//        List<Book> books = bookService.getBooksByGenre(genreId);
//        if (books.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(books);
//        }
//    }

    //getBooksByGenre
    //
//    @GetMapping("/genre/{genresId}")
//    public ResponseEntity<?> getBooksByGenres(@PathVariable int genresId){
//        List<Book> books = bookService.getBooksByGenres(genresId);
//        if(books.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
//        }else {
//            return ResponseEntity.ok(books);
//        }
//    }

    @GetMapping("/genre/{id}/books")
    public ResponseEntity<List<Book>> getBooksByGenreId(@PathVariable int id){
        List<Book> books = bookService.getBooksByGenreId(id);
        if(!books.isEmpty()){
            return ResponseEntity.ok(books);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(books);
        }
    }
}
