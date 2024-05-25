package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
public class Inventory {
    public  Inventory(int quantity, LocalDate dateAdded, LocalDate dateModified){
        this.quantity = quantity;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private LocalDate dateAdded;
    private LocalDate dateModified;
}
