package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Optional<Integer> findIdByNameAndLocation(String name, String location);

    Optional<Publisher> findByNameAndLocation(String name, String location);

}
