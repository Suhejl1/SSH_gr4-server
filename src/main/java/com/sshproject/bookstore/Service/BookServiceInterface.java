package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    int addBook(Book book);

    List<Book> getBooks();

    List<Integer> deleteBooks();

    Optional<Book> getBookById(int id);

    String updateBook(int id, Book book);

//    List<Book> getBooksByAuthorId(int id);

}
