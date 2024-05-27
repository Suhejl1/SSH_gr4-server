package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Optional<Genre> findByName(String name);
    //Jpa functionalities

}
