package com.sshproject.bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="book_tags")
public class BookTag {

    public BookTag(int bookId, String tagName) {
//        this.book = new Book();
//        this.book.setId(bookId);
        this.bookId = bookId;
        this.tagName = tagName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//     @ManyToOne
//    @JoinColumn(name = "book_id", referencedColumnName = "id")
//    private Book book;

    private int bookId;

    private String tagName;



}
