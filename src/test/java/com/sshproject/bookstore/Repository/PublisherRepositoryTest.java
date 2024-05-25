package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void testFindById() {
        // Arrange
        Publisher publisher1 = new Publisher("Publisher1", "Location1");
        Publisher publisher2 = new Publisher("Publisher2", "Location2");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        // Act
        Optional<Publisher> foundPublisher1 = publisherRepository.findById(publisher1.getId());
        Optional<Publisher> foundPublisher2 = publisherRepository.findById(publisher2.getId());

        // Assert
        assertThat(foundPublisher1).isPresent();
        assertThat(foundPublisher1.get().getName()).isEqualTo("Publisher1");
        assertThat(foundPublisher1.get().getLocation()).isEqualTo("Location1");

        assertThat(foundPublisher2).isPresent();
        assertThat(foundPublisher2.get().getName()).isEqualTo("Publisher2");
        assertThat(foundPublisher2.get().getLocation()).isEqualTo("Location2");
    }
}
