package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Faq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FaqRepositoryTest {

    @Autowired
    private FaqRepository faqRepository;

    @Test
    public void testSaveAndFindById() {
        // Arrange
        Faq faq = new Faq("What is Lorem Ipsum?", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        // Act
        Faq savedFaq = faqRepository.save(faq);
        Faq foundFaq = faqRepository.findById(savedFaq.getId()).orElse(null);

        // Assert
        assertThat(foundFaq).isNotNull();
        assertThat(foundFaq.getQuestion()).isEqualTo("What is Lorem Ipsum?");
        assertThat(foundFaq.getAnswer()).isEqualTo("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
    }

    @Test
    public void testDelete() {
        // Arrange
        Faq faq = new Faq("What is Lorem Ipsum?", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        Faq savedFaq = faqRepository.save(faq);

        // Act
        faqRepository.deleteById(savedFaq.getId());
        Faq foundFaq = faqRepository.findById(savedFaq.getId()).orElse(null);

        // Assert
        assertThat(foundFaq).isNull();
    }
}
