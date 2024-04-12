package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSaveBook(){
        //Given
        Book book = new Book("Book1", 1,"123456789",1,2024,"","",1);

        // When
        Book savedBook = bookRepository.save(book);

        // Then
        Assertions.assertThat(savedBook.getId()).isGreaterThan(0);

    }
}