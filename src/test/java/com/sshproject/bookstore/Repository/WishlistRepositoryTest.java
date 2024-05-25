package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Wishlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class WishlistRepositoryTest {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Test
    public void testFindByUserId() {
        // Arrange
        Wishlist wishlist1 = new Wishlist(1, 1);
        Wishlist wishlist2 = new Wishlist(2, 1);
        Wishlist wishlist3 = new Wishlist(3, 2);

        wishlistRepository.save(wishlist1);
        wishlistRepository.save(wishlist2);
        wishlistRepository.save(wishlist3);

        // Act
        List<Wishlist> user1Wishlist = wishlistRepository.findByUserId(1);
        List<Wishlist> user2Wishlist = wishlistRepository.findByUserId(2);
        List<Wishlist> user3Wishlist = wishlistRepository.findByUserId(3);

        // Assert
        assertThat(user1Wishlist).hasSize(2);
        assertThat(user2Wishlist).hasSize(1);
        assertThat(user3Wishlist).isEmpty();
    }

    @Test
    public void testExistsByBookIdAndUserId() {
        // Arrange
        Wishlist wishlist1 = new Wishlist(1, 1);
        wishlistRepository.save(wishlist1);

        // Act
        boolean exists1 = wishlistRepository.existsByBookIdAndUserId(1, 1);
        boolean exists2 = wishlistRepository.existsByBookIdAndUserId(2, 1);

        // Assert
        assertThat(exists1).isTrue();
        assertThat(exists2).isFalse();
    }

    @Test
    public void testDeleteByBookIdAndUserId() {
        // Arrange
        Wishlist wishlist1 = new Wishlist(1, 1);
        wishlistRepository.save(wishlist1);

        // Act
        wishlistRepository.deleteByBookIdAndUserId(1, 1);

        // Assert
        assertThat(wishlistRepository.existsByBookIdAndUserId(1, 1)).isFalse();
    }

    @Test
    public void testDeleteByUserId() {
        // Arrange
        Wishlist wishlist1 = new Wishlist(1, 1);
        Wishlist wishlist2 = new Wishlist(2, 1);
        wishlistRepository.save(wishlist1);
        wishlistRepository.save(wishlist2);

        // Act
        wishlistRepository.deleteByUserId(1);

        // Assert
        assertThat(wishlistRepository.findByUserId(1)).isEmpty();
        assertThat(wishlistRepository.findByUserId(2)).isNotEmpty();
    }
}
