package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Role;
import com.sshproject.bookstore.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmailAddress() {
        // Arrange
        Role role1 = new Role("Admin");
        Role role2 = new Role("User");

        User user1 = new User("admin@example.com", "adminPassword", role1.getName());
        User user2 = new User("user@example.com", "userPassword", role2.getName());

        userRepository.save(user1);
        userRepository.save(user2);

        // Act
        Optional<User> foundUser1 = userRepository.findByEmailAddress("admin@example.com");
        Optional<User> foundUser2 = userRepository.findByEmailAddress("user@example.com");
        Optional<User> foundUser3 = userRepository.findByEmailAddress("nonexistent@example.com");

        // Assert
        assertThat(foundUser1).isPresent();
        assertThat(foundUser1.get().getEmailAddress()).isEqualTo("admin@example.com");

        assertThat(foundUser2).isPresent();
        assertThat(foundUser2.get().getEmailAddress()).isEqualTo("user@example.com");

        assertThat(foundUser3).isEmpty();
    }
}
