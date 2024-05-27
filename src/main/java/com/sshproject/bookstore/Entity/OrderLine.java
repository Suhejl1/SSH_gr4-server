package com.sshproject.bookstore.Entity;
/* This entity serves as a bridge between the order and the product*/


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "order_line")
public class OrderLine {
    public OrderLine(int productItemId, int orderId, int quantity, double price) {
        this.productItemId = productItemId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productItemId;
    private int orderId;
    private int quantity;
    private double price;



}
