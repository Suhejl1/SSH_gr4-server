package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
public class Inventory {
    public  Inventory(int quantity, String date_added, String date_modified){
        this.quantity = quantity;
        this.date_added = date_added;
        this.date_modified = date_modified;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private String date_added;
    private String date_modified;
}
