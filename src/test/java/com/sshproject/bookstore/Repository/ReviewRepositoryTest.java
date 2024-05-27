package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void testFindByUserId() {
        // Arrange
        Review review1 = new Review(1, 1, 5, "Great book!");
        Review review2 = new Review(1, 2, 4, "Interesting read");

        reviewRepository.save(review1);
        reviewRepository.save(review2);

        // Act
        List<Review> user1Reviews = reviewRepository.findByUserId(1);
        List<Review> user2Reviews = reviewRepository.findByUserId(2);

        // Assert
        assertThat(user1Reviews).hasSize(2);
        assertThat(user2Reviews).isEmpty();
    }
}
