package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_type")
@Data
@NoArgsConstructor
public class PaymentType {


    // Constructors, getters, and setters
    public PaymentType(String paymentValue) {
        this.paymentValue = paymentValue;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String paymentValue;
}
