package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Favorite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FavoriteRepositoryTest {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Test
    public void testFindByBookId() {
        // Arrange
        Favorite favorite1 = new Favorite(1, 1);
        Favorite favorite2 = new Favorite(2, 1);
        Favorite favorite3 = new Favorite(3, 2);

        favoriteRepository.save(favorite1);
        favoriteRepository.save(favorite2);
        favoriteRepository.save(favorite3);

        // Act
        List<Favorite> book1Favorites = favoriteRepository.findByBookId(1);
        List<Favorite> book2Favorites = favoriteRepository.findByBookId(2);
        List<Favorite> book3Favorites = favoriteRepository.findByBookId(3);

        // Assert
        assertThat(book1Favorites).hasSize(2);
        assertThat(book2Favorites).hasSize(1);
        assertThat(book3Favorites).hasSize(1);
    }
}
