package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Book;
import com.sshproject.bookstore.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
    //Jpa functionalities

}
