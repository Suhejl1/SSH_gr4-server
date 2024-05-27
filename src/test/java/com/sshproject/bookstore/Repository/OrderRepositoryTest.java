package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testFindByUserId() {
        // Arrange
        LocalDate orderDate = LocalDate.now();
        Order order1 = new Order(1, orderDate, 1, 1, BigDecimal.valueOf(100));
        Order order2 = new Order(2, orderDate, 2, 2, BigDecimal.valueOf(200));

        orderRepository.save(order1);
        orderRepository.save(order2);

        // Act
        List<Order> user1Orders = orderRepository.findByUserId(1);
        List<Order> user2Orders = orderRepository.findByUserId(2);

        // Assert
        assertThat(user1Orders).hasSize(1);
        assertThat(user2Orders).hasSize(1);
    }
}
