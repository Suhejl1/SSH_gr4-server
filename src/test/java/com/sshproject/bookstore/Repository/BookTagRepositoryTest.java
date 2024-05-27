package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookTagRepositoryTest {

    @Autowired
    private BookTagRepository bookTagRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindByTagName() {

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
        Book book1 = new Book("Book2", 1, "123456789", 1, 2024, 10.2, "", "", 1);
        Book book2 = new Book("Book3", 1, "123456789", 1, 2024, 10.2, "", "", 1);

        bookRepository.save(book);
        bookRepository.save(book1);
        bookRepository.save(book2);


        // Arrange
        BookTag tag1 = new BookTag(1, "tag1");
        BookTag tag2 = new BookTag(1, "tag2");
        BookTag tag3 = new BookTag(2, "tag3");



        bookTagRepository.save(tag1);
        bookTagRepository.save(tag2);
        bookTagRepository.save(tag3);

        // Act
        List<BookTag> tagsForBook1 = bookTagRepository.findByTagName("tag1");
        List<BookTag> tagsForBook2 = bookTagRepository.findByTagName("tag3");

        // Assert
        assertThat(tagsForBook1).hasSize(1);
        assertThat(tagsForBook1.get(0).getTagName()).isEqualTo("tag1");

        assertThat(tagsForBook2).hasSize(1);
        assertThat(tagsForBook2.get(0).getTagName()).isEqualTo("tag3");
    }
}
