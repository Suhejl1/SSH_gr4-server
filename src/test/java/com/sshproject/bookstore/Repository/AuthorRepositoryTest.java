package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindIdByNameAndNationalityAndBirthDate() {
        // Arrange
        Author author = new Author("Author Name", "Nationality", LocalDate.of(1980, 1, 1));
        authorRepository.save(author);

        // Act
        Optional<Author> foundAuthor = authorRepository.findByNameAndNationalityAndBirthDate("Author Name", "Nationality", LocalDate.of(1980, 1, 1));

        // Assert
        assertThat(foundAuthor).isPresent();
        assertThat(foundAuthor.get().getId()).isEqualTo(author.getId());
    }
}
