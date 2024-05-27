package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
@Data //This annotation replaces @Getter, @Setter and @toString. :)
@NoArgsConstructor
public class Book {
    public Book(String title, int author_id, String isbn, int publisher, int publishing_year,double price, String image, String description, int inventory_id) {
        this.title = title;
        this.authorId = author_id;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishing_year = publishing_year;
        this.price = price;
        this.image = image;
        this.description = description;
        this.inventory_id = inventory_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This annotation creates the primary key generation strategy
    //Identity strategy auto increments the primary key
    private int id;

//    @Column(name="new-column-name", length = 512, nullable=false) - This annotation can change column properties, name, length and more
    private String title;
    private int authorId;
    private String isbn;
    private int publisher;
    private double price;
    private int publishing_year;
    private String image;
    private String description;
    private int inventory_id;
}
