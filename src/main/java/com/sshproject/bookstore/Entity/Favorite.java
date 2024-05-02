package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@Table(name="favourites")

public class Favorite {
    public Favorite(int user_id, int book_id) {
        this.user_id = user_id;
        this.book_id = book_id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private int book_id;
}
