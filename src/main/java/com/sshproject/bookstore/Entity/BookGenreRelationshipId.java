package com.sshproject.bookstore.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class BookGenreRelationshipId implements Serializable {

    private int bookId;
    private int genresId;

    public BookGenreRelationshipId() {
    }

    public BookGenreRelationshipId(int bookId, int genresId) {
        this.bookId = bookId;
        this.genresId = genresId;
    }

    // Getters, setters, hashCode, equals...

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getGenreId() {
        return genresId;
    }

    public void setGenreId(int genreId) {
        this.genresId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookGenreRelationshipId that = (BookGenreRelationshipId) o;
        return bookId == that.bookId && genresId == that.genresId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genresId);
    }
}
