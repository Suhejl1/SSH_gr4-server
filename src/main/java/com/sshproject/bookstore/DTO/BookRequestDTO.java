package com.sshproject.bookstore.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookRequestDTO {
    private String title;
    private double price;
    private String authorName;
    private String authorNationality;
    private LocalDate authorBirthDate; // Consider using LocalDate
    private String publisherName;
    private String publisherLocation;
    private int publishingYear;
    private String image;
    private String description;
    private int quantity;
    private String isbn;

}
