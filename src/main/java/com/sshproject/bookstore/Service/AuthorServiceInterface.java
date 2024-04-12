package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Author;
import com.sshproject.bookstore.Entity.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorServiceInterface {

    int deleteAuthorById(int id);
    int addAuthor(Author author);
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(int id);

//    List<Book> getAuthorBooks(int id);




}
