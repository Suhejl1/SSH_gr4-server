package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface{

    @Autowired
    private BookRepository bookRepository;



    //CREATE
    @Override
    public int addBook(Book book) {
        Book new_book = new Book(book.getTitle(),book.getAuthor_id(),book.getISBN(),
                book.getPublisher(),book.getYear(),book.getImage(),book.getDescription(),book.getInventory_id());
        bookRepository.save(new_book);
        return new_book.getId();
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        for(Book b : books){
            System.out.println(b.getDescription());
        }
        return books;
    }

    @Override
    public List<Integer> deleteBooks() {
        List<Book> deletedBooks = bookRepository.findAll();
        List<Integer> deletedBookIds = new ArrayList<>();

        for (Book book : deletedBooks) {
            deletedBookIds.add(book.getId());
        }

        bookRepository.deleteAll();

        return deletedBookIds;
    }

    @Override
    public Optional<Book> getBookById(int id) {
        Optional<Book> book =  bookRepository.findById(id);
        if (book.isPresent()) {
            return book;
        }
        return null;
    }


    //Why are we passing Book as a parameter? This is futureproof, as it allows us to update any field we want on the book,
    //without the need of creating a seperate update method for each book field
    @Override
    public String updateBook(int id, Book updated_book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updated_book.getTitle());
            // Update other fields as needed

            bookRepository.save(existingBook);
            return "Book updated";
        } else {
            return "Could not update book";
        }
    }

//    @Override
//    public List<Book> getBooksByAuthorId(int id) {
//        return bookRepository.findByAuthor_id(id);
//    }


}
