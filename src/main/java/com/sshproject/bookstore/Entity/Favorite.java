package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@Table(name="favourites")

public class Favorite {
    public Favorite(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private int bookId;
}
