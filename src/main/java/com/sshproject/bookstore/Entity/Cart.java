package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="shopping_cart_items")
public class Cart {
    public Cart(int cart_id, int product_item_id, int quantity) {
        this.cart_id = cart_id;
        this.product_item_id = product_item_id;
        this.quantity = quantity;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cart_id;
    private int product_item_id;
    private int quantity;
}
