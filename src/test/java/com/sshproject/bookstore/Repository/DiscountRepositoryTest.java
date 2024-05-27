package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Discount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DiscountRepositoryTest {

    @Autowired
    private DiscountRepository discountRepository;

    @Test
    public void testFindByDiscountCode() {
        // Arrange
        Discount discount1 = new Discount("CODE1", 0.1, LocalDate.now().plusDays(7));
        Discount discount2 = new Discount("CODE2", 0.2, LocalDate.now().plusDays(14));

        discountRepository.save(discount1);
        discountRepository.save(discount2);

        // Act
        Discount foundDiscount1 = discountRepository.findByDiscountCode("CODE1");
        Discount foundDiscount2 = discountRepository.findByDiscountCode("CODE2");
        Discount foundDiscount3 = discountRepository.findByDiscountCode("NON_EXISTING_CODE");

        // Assert
        assertThat(foundDiscount1).isNotNull();
        assertThat(foundDiscount1.getDiscountCode()).isEqualTo("CODE1");
        assertThat(foundDiscount1.getDiscount_percentage()).isEqualTo(0.1);
        assertThat(foundDiscount1.getExpire_date()).isEqualTo(LocalDate.now().plusDays(7));

        assertThat(foundDiscount2).isNotNull();
        assertThat(foundDiscount2.getDiscountCode()).isEqualTo("CODE2");
        assertThat(foundDiscount2.getDiscount_percentage()).isEqualTo(0.2);
        assertThat(foundDiscount2.getExpire_date()).isEqualTo(LocalDate.now().plusDays(14));

        assertThat(foundDiscount3).isNull();
    }
}
