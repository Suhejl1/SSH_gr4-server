package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Repository.BookRepository;
import com.sshproject.bookstore.Service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.*;

import static org.mockito.Mockito.*;
// Using MOCK to focus in the behaviour of BookService without involving the actual database or repository impl.
public class BookServiceTets {

    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBook(){
        Book newBook = new Book("New Book", 1, "123456789", 1,
                2024, "", "", 1);

        // Mock the save method of bookRepository
        when(bookRepository.save(any(Book.class))).thenReturn(newBook);

        int bookId = bookService.addBook(newBook);

        // Verify that the save method was called once with the newBook object
        verify(bookRepository, times(1)).save(newBook);

        // Assert that the returned bookId matches the ID of the newBook
        Assertions.assertEquals(newBook.getId(), bookId);
    }
    @Test
    public void testGetBooks(){
        List<Book> books = Arrays.asList(
                new Book("Book 1", 1, "111", 1, 2020, "", "", 1),
                new Book("Book 2", 2, "222", 2, 2021, "", "", 2)
        );

        // Mock the behavior of BookRepository.findAll() method
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> resultBooks = bookService.getBooks();

        // Verify that findAll() method of BookRepository is called exactly once
        verify(bookRepository, times(1)).findAll();

        Assertions.assertEquals(books.size(),resultBooks.size());
        Assertions.assertEquals(books.get(0).getTitle(), resultBooks.get(0).getTitle());
        Assertions.assertEquals(books.get(1).getTitle(), resultBooks.get(1).getTitle());

    }

    @Test
    public void testDeleteBooks() {
        List<Book> books = Arrays.asList(
                new Book("Book 1", 1, "111", 1, 2020, "", "", 1),
                new Book("Book 2", 2, "222", 2, 2021, "", "", 2)
        );
        when(bookRepository.findAll()).thenReturn(books);

        List<Integer> deletedBookIds = bookService.deleteBooks();

        verify(bookRepository, times(1)).findAll();
        verify(bookRepository, times(1)).deleteAll();

        Assertions.assertEquals(books.size(), deletedBookIds.size());
        Assertions.assertEquals(books.get(0).getId(), deletedBookIds.get(0));
        Assertions.assertEquals(books.get(1).getId(), deletedBookIds.get(1));
    }

    @Test
    public void testGetBookById() {
        int bookId = 1;
        Book book = new Book("Book 1", 1, "111", 1, 2020, "", "", bookId);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById(bookId);

        verify(bookRepository, times(1)).findById(bookId);

        Assertions.assertTrue(foundBook.isPresent());
        Assertions.assertEquals(book.getTitle(), foundBook.get().getTitle());
    }

    @Test
    public void testUpdateBook() {
        int bookId = 1;
        Book existingBook = new Book("Book 1", 1, "111", 1, 2020, "", "", bookId);
        Book updatedBook = new Book("Updated Book", 1, "111", 1, 2020, "", "", bookId);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        String result = bookService.updateBook(bookId, updatedBook);

        verify(bookRepository, times(1)).findById(bookId);
        verify(bookRepository, times(1)).save(updatedBook);

        Assertions.assertEquals("Book updated", result);

        Assertions.assertEquals(updatedBook.getTitle(), existingBook.getTitle());
    }

}
