package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.BookTag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookTagRepositoryTest {

    @Autowired
    private BookTagRepository bookTagRepository;

    @Test
    public void testFindByTagName() {
        // Arrange
        BookTag tag1 = new BookTag(1, "tag1");
        BookTag tag2 = new BookTag(1, "tag2");
        BookTag tag3 = new BookTag(2, "tag3");

        bookTagRepository.save(tag1);
        bookTagRepository.save(tag2);
        bookTagRepository.save(tag3);

        // Act
        List<BookTag> tagsForBook1 = bookTagRepository.findByTagName("tag1");
        List<BookTag> tagsForBook2 = bookTagRepository.findByTagName("tag3");

        // Assert
        assertThat(tagsForBook1).hasSize(1);
        assertThat(tagsForBook1.get(0).getTagName()).isEqualTo("tag1");

        assertThat(tagsForBook2).hasSize(1);
        assertThat(tagsForBook2.get(0).getTagName()).isEqualTo("tag3");
    }
}
