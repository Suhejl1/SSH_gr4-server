package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByAuthorId(int author_id);

    Optional<Book> findByIsbn(String isbn);
    //In repositories there is no method or code written because it gets it all from parent class JpaRepository

}
