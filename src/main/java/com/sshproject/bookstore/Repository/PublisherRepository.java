package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    //Jpa functionalities

}
