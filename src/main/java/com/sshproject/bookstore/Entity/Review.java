package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="reviews")
public class Review {

    public Review(int userId, int ordered_book_id, int rating_value, String comment) {
        this.userId = userId;
        this.ordered_book_id = ordered_book_id;
        this.rating_value = rating_value;
        this.comment = comment;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private int ordered_book_id;
    private int rating_value;
    private String comment;
}
