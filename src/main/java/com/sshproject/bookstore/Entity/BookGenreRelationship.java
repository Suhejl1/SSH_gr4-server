package com.sshproject.bookstore.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="books_genres_relationship")
public class BookGenreRelationship {
    @EmbeddedId
    private BookGenreRelationshipId id;

    public BookGenreRelationship(int bookId, int genresId) {
            this.id = new BookGenreRelationshipId(bookId, genresId);
    }

    public BookGenreRelationship(BookGenreRelationshipId id) {
        this.id = id;
    }



}
