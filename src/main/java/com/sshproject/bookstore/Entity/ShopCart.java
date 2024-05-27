package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "shoping_cart")
public class ShopCart {

    public ShopCart(int userId) {
        this.userId = userId;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;

}
