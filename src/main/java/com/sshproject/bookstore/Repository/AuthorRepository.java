package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    //Jpa functionalities
}
