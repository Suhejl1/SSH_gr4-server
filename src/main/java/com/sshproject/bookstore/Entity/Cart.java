package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="shopping_cart_items")
public class Cart {
    public Cart(int cartId, int productItemId, int quantity) {
        this.cartId = cartId;
        this.productItemId = productItemId;
        this.quantity = quantity;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cartId;
    private int productItemId;
    private int quantity;
}
