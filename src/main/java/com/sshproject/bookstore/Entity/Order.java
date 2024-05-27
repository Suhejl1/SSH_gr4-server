package com.sshproject.bookstore.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "shop_orders")
public class Order {
    public Order(int userId, LocalDate orderDate,  String shippingAddress, double orderTotal) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderTotal = orderTotal;

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private LocalDate orderDate;
    private String shippingAddress;
    private double orderTotal;







}
