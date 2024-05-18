package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users_payment_methods")
public class UserPaymentMethod {

    public UserPaymentMethod(int userId, int paymentTypeId, String provider, String accountNumber, LocalDate expireDate, boolean isDefault) {
        this.userId = userId;
        this.paymentTypeId = paymentTypeId;
        this.provider = provider;
        this.accountNumber = accountNumber;
        this.expireDate = expireDate;
        this.isDefault = isDefault;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int paymentTypeId;
    private String provider;
    private String accountNumber;
    private LocalDate expireDate;
    private boolean isDefault;
}
