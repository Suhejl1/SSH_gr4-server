package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Ability;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AbilityRepositoryTest {

    @Autowired
    private AbilityRepository abilityRepository;

    @Test
    public void testFindByModelNameAndVerbAndField() {
        // Arrange
        Ability ability = new Ability("ModelA", "READ", "FieldA");
        abilityRepository.save(ability);

        // Act
        Optional<Ability> foundAbility = abilityRepository.findByModelNameAndVerbAndField("ModelA", "READ", "FieldA");

        // Assert
        assertThat(foundAbility).isPresent();
        assertThat(foundAbility.get().getId()).isEqualTo(ability.getId());
        assertThat(foundAbility.get().getModelName()).isEqualTo("ModelA");
        assertThat(foundAbility.get().getVerb()).isEqualTo("READ");
        assertThat(foundAbility.get().getField()).isEqualTo("FieldA");
    }

    @Test
    public void testFindByModelNameAndVerbAndField_NotFound() {
        // Act
        Optional<Ability> foundAbility = abilityRepository.findByModelNameAndVerbAndField("NonExistingModel", "WRITE", "NonExistingField");

        // Assert
        assertThat(foundAbility).isNotPresent();
    }
}
