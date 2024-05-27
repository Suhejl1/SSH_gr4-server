package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.BookGenreRelationship;
import com.sshproject.bookstore.Entity.BookGenreRelationshipId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookGenreRelationshipRepositoryTest {

    @Autowired
    private BookGenreRelationshipRepository bookGenreRelationshipRepository;

    @Test
    public void testSaveAndFindById() {
        // Arrange
        BookGenreRelationshipId id = new BookGenreRelationshipId(1, 1);
        BookGenreRelationship relationship = new BookGenreRelationship(id);

        // Act
        bookGenreRelationshipRepository.save(relationship);
        Optional<BookGenreRelationship> foundRelationship = bookGenreRelationshipRepository.findById(id);

        // Assert
        assertThat(foundRelationship).isPresent();
        assertThat(foundRelationship.get().getId()).isEqualTo(id);
    }

    @Test
    public void testDelete() {
        // Arrange
        BookGenreRelationshipId id = new BookGenreRelationshipId(1, 1);
        BookGenreRelationship relationship = new BookGenreRelationship(id);
        bookGenreRelationshipRepository.save(relationship);

        // Act
        bookGenreRelationshipRepository.deleteById(id);
        Optional<BookGenreRelationship> foundRelationship = bookGenreRelationshipRepository.findById(id);

        // Assert
        assertThat(foundRelationship).isNotPresent();
    }
}
