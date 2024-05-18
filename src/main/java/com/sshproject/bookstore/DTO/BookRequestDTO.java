package com.sshproject.bookstore.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BookRequestDTO {
    private String title;
    private double price;
    private String authorName;
    private String authorNationality;
    private LocalDate authorBirthDate;
    private String publisherName;
    private String publisherLocation;
    private int publishingYear;
    private String image;
    private String description;
    private int quantity;
    private String isbn;
    private List<String> genres;  // Added genres field
}
