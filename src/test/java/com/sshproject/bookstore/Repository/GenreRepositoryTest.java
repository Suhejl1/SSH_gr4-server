package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testFindByName() {
        // Arrange
        Genre genre1 = new Genre("Fantasy");
        Genre genre2 = new Genre("Mystery");

        genreRepository.save(genre1);
        genreRepository.save(genre2);

        // Act
        Optional<Genre> foundGenre1 = genreRepository.findByName("Fantasy");
        Optional<Genre> foundGenre2 = genreRepository.findByName("Mystery");
        Optional<Genre> foundGenre3 = genreRepository.findByName("Science Fiction");

        // Assert
        assertThat(foundGenre1).isPresent();
        assertThat(foundGenre1.get().getName()).isEqualTo("Fantasy");

        assertThat(foundGenre2).isPresent();
        assertThat(foundGenre2.get().getName()).isEqualTo("Mystery");

        assertThat(foundGenre3).isNotPresent();
    }
}
