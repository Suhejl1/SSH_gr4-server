package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // You can add custom query methods here if needed
    List<Review> findByUserId(int userId);
//    List<Review> findByOrderedBookId(int orderedBookId);


}
