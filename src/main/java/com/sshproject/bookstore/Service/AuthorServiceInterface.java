package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Author;
import com.sshproject.bookstore.Entity.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AuthorServiceInterface {
    Optional<Author> getAuthorById(int id);
    int addAuthor(Author author);
    List<Author> getAllAuthors();
    int deleteAuthorById(int id);
    List<Book> getAuthorBooks(int id);

    // New method
    Optional<Integer> findAuthorIdByDetails(String name, String nationality, LocalDate birthDate);
}
