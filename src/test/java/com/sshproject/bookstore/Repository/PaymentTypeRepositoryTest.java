package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.PaymentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PaymentTypeRepositoryTest {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Test
    public void testFindByPaymentValue() {
        // Arrange
        PaymentType paymentType1 = new PaymentType("Credit Card");
        PaymentType paymentType2 = new PaymentType("PayPal");

        paymentTypeRepository.save(paymentType1);
        paymentTypeRepository.save(paymentType2);

        // Act
        Optional<PaymentType> foundPaymentType1 = paymentTypeRepository.findById(paymentType1.getId());
        Optional<PaymentType> foundPaymentType2 = paymentTypeRepository.findById(paymentType2.getId());

        // Assert
        assertThat(foundPaymentType1).isPresent();
        assertThat(foundPaymentType1.get().getPaymentValue()).isEqualTo("Credit Card");

        assertThat(foundPaymentType2).isPresent();
        assertThat(foundPaymentType2.get().getPaymentValue()).isEqualTo("PayPal");
    }
}
