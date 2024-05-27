package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Author;
import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Inventory;
import com.sshproject.bookstore.Entity.Publisher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
import java.time.LocalDate;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    public void testSaveBook() {
        // Given
        Author author = new Author("Author Name", "Nationality", LocalDate.of(1970, 1, 1));

        entityManager.persist(author);
        entityManager.flush(); // Ensure the author is persisted before the book
        Publisher publisher = new Publisher("Visar Gjema", "Prishtine");

        entityManager.persist(publisher);
        entityManager.flush();

        Inventory inventory = new Inventory(2,LocalDate.now(),LocalDate.now());

        entityManager.persist(inventory);
        entityManager.flush();

        Book book = new Book("Book1", 1, "123456789", 1, 2024, 10.2, "", "", 1);

        // When
        Book savedBook = bookRepository.save(book);

        // Then
        Assertions.assertThat(savedBook.getId()).isGreaterThan(0);
    }
}