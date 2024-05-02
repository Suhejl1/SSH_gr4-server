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
    public  Inventory(int quantity, LocalDate date_added, LocalDate date_modified){
        this.quantity = quantity;
        this.date_added = date_added;
        this.date_modified = date_modified;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private LocalDate date_added;
    private LocalDate date_modified;
}
