package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AbilityRepository extends JpaRepository<Ability,Integer> {
    Optional<Ability> findByModelNameAndVerbAndField(String modelName, String verb, String field);
    //After getting the Ability object we extract the ability id from it
}
