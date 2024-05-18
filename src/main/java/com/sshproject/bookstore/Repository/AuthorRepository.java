package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Integer> findIdByNameAndNationalityAndBirthDate(String name, String nationality, LocalDate birthDate);
    Optional<Author> findByNameAndNationalityAndBirthDate(String name, String nationality, LocalDate birthDate);
}
