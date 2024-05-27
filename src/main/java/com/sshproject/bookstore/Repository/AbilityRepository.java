package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AbilityRepository extends JpaRepository<Ability,Integer> {
    Optional<Ability> findByModelNameAndVerb(String modelName, String verb);
    //After getting the Ability object we extract the ability id from it

    @Query("SELECT a.field FROM Ability a WHERE :endpoint LIKE CONCAT(a.verb, '%') and :method=a.modelName")
    String getByEndpointPrefix(@Param("method") String method, @Param("endpoint") String endpoint);

    @Query("SELECT a.verb from Ability a WHERE :method=a.modelName and :endpoint=a.verb")
    String getCorrectEndpoint(@Param("method") String method, @Param("endpoint") String endpoint);
}
