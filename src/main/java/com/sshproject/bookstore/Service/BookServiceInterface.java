package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.DTO.BookRequestDTO;
import com.sshproject.bookstore.Entity.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {
    int addBook(BookRequestDTO bookRequestDTO);
    List<Book> getBooks();
    List<Integer> deleteBooks();
    Optional<Book> getBookById(int id);
    String updateBook(int id, Book updatedBook);
    List<Book> getBooksByAuthorId(int id);
    List<Book> getBooksByIds(List<Integer> ids);

    Optional<Integer> findAuthorIdByDetails(String name, String nationality, LocalDate birthDate);
    int addAuthor(String name, String nationality, LocalDate birthDate);

    Optional<Integer> findPublisherIdByDetails(String name, String location);
    int addPublisher(String name, String location);
}
