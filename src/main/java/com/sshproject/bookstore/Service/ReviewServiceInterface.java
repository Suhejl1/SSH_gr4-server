package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewServiceInterface {
    List<Review> getAllReviews();

    int addReview(Review review);

    void deleteReview(int reviewId);
}
