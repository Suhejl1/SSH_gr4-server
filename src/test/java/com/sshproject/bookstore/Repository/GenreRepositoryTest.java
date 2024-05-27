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
        Genre genre1 = new Genre("Fantasy1");
        Genre genre2 = new Genre("Mystery1");

        genreRepository.save(genre1);
        genreRepository.save(genre2);

        // Act
        Optional<Genre> foundGenre1 = genreRepository.findByName("Fantasy1");
        Optional<Genre> foundGenre2 = genreRepository.findByName("Mystery1");

        // Assert
        assertThat(foundGenre1).isPresent();
        assertThat(foundGenre1.get().getName()).isEqualTo("Fantasy1");

        assertThat(foundGenre2).isPresent();
        assertThat(foundGenre2.get().getName()).isEqualTo("Mystery1");


    }
}
