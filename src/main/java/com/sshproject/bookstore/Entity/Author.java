package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="authors")
public class Author {
    public Author(String name, String nationality, Date birth_date) {
        this.name = name;
        this.nationality = nationality;
        this.birth_date = birth_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nationality;
    private Date birth_date;
}
