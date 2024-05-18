package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.BookGenreRelationship;
import com.sshproject.bookstore.Entity.BookGenreRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRelationshipRepository extends JpaRepository<BookGenreRelationship, BookGenreRelationshipId> {
}
