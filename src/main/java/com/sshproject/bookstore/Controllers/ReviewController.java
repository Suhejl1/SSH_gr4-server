package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Review;
import com.sshproject.bookstore.Service.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewServiceInterface reviewService;

    @GetMapping("api/v1/reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping("api/v1/reviews")
    public int addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @DeleteMapping("api/v1/reviews/{reviewId}")
    public void deleteReview(@PathVariable int reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
