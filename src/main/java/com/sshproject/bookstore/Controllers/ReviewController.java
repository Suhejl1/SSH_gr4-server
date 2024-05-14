package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Review;
import com.sshproject.bookstore.Service.ReviewServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewServiceInterface reviewService;

    @GetMapping("api/v1/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        if (reviews.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(reviews);
        }
    }

    @PostMapping("api/v1/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        int result = reviewService.addReview(review);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Review added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add review");
        }
    }

    @DeleteMapping("api/v1/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {
        boolean deleted = reviewService.deleteReview(reviewId);
        if (deleted) {
            return ResponseEntity.ok("Review deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
