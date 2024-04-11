package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    //In repositories there is no method or code written because it gets it all from parent class JpaRepository

}
