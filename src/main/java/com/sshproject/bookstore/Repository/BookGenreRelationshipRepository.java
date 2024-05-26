package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.BookGenreRelationship;
import com.sshproject.bookstore.Entity.BookGenreRelationshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookGenreRelationshipRepository extends JpaRepository<BookGenreRelationship, BookGenreRelationshipId> {
    @Query("SELECT bgr.id.bookId FROM BookGenreRelationship bgr WHERE bgr.id.genresId = :genresId")
    List<Integer> findBookIdByGenresId(int genresId);
}

