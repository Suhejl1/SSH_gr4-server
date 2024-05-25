package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testFindByName() {
        // Arrange
        Role role1 = new Role("Admin");
        Role role2 = new Role("User");

        roleRepository.save(role1);
        roleRepository.save(role2);

        // Act
        Role foundRole1 = roleRepository.findByName("Admin");
        Role foundRole2 = roleRepository.findByName("User");
        Role foundRole3 = roleRepository.findByName("NonExistentRole");

        // Assert
        assertThat(foundRole1).isNotNull();
        assertThat(foundRole1.getName()).isEqualTo("Admin");

        assertThat(foundRole2).isNotNull();
        assertThat(foundRole2.getName()).isEqualTo("User");

        assertThat(foundRole3).isNull();
    }
}
