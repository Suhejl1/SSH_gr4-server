package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testFindByUserId() {
        // Arrange
        Cart cart1 = new Cart(1, 1, 2);
        Cart cart2 = new Cart(1, 2, 1);
        Cart cart3 = new Cart(2, 3, 3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        // Act
        List<Cart> user1CartItems = cartRepository.findByUserId(1);
        List<Cart> user2CartItems = cartRepository.findByUserId(2);

        // Assert
        assertThat(user1CartItems).hasSize(2);
        assertThat(user2CartItems).hasSize(1);
    }

    @Test
    public void testDeleteByUserIdAndBookId() {
        // Arrange
        Cart cart1 = new Cart(1, 1, 2);
        Cart cart2 = new Cart(1, 2, 1);
        Cart cart3 = new Cart(2, 3, 3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        // Act
        cartRepository.deleteByUserIdAndBookId(1, 1);
        List<Cart> user1CartItems = cartRepository.findByUserId(1);

        // Assert
        assertThat(user1CartItems).hasSize(1);
    }

    @Test
    public void testDeleteByUserId() {
        // Arrange
        Cart cart1 = new Cart(1, 1, 2);
        Cart cart2 = new Cart(1, 2, 1);
        Cart cart3 = new Cart(2, 3, 3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        // Act
        cartRepository.deleteByUserId(1);
        List<Cart> user1CartItems = cartRepository.findByUserId(1);

        // Assert
        assertThat(user1CartItems).isEmpty();
    }

    @Test
    public void testFindByUserIdAndBookId() {
        // Arrange
        Cart cart1 = new Cart(1, 1, 2);
        Cart cart2 = new Cart(1, 2, 1);
        Cart cart3 = new Cart(2, 3, 3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);

        // Act
        Cart foundCart = cartRepository.findByUserIdAndBookId(1, 1);

        // Assert
        assertThat(foundCart).isNotNull();
        assertThat(foundCart.getQuantity()).isEqualTo(2);
    }
}
