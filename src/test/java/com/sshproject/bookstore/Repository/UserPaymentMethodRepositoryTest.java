package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.UserPaymentMethod;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserPaymentMethodRepositoryTest {

    @Autowired
    private UserPaymentMethodRepository userPaymentMethodRepository;

    @Test
    public void testFindByUserId() {
        // Arrange
        UserPaymentMethod paymentMethod1 = new UserPaymentMethod(1, 1, "Provider1", "123456789", LocalDate.now(), true);
        UserPaymentMethod paymentMethod2 = new UserPaymentMethod(1, 2, "Provider2", "987654321", LocalDate.now(), false);
        UserPaymentMethod paymentMethod3 = new UserPaymentMethod(2, 1, "Provider3", "555555555", LocalDate.now(), true);

        userPaymentMethodRepository.save(paymentMethod1);
        userPaymentMethodRepository.save(paymentMethod2);
        userPaymentMethodRepository.save(paymentMethod3);

        // Act
        List<UserPaymentMethod> user1PaymentMethods = userPaymentMethodRepository.findByUserId(1);
        List<UserPaymentMethod> user2PaymentMethods = userPaymentMethodRepository.findByUserId(2);
        List<UserPaymentMethod> user3PaymentMethods = userPaymentMethodRepository.findByUserId(3);

        // Assert
        assertThat(user1PaymentMethods).hasSize(2);
        assertThat(user2PaymentMethods).hasSize(1);
        assertThat(user3PaymentMethods).isEmpty();
    }
}
