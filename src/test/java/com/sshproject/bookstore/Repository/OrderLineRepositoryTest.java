package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.OrderLine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderLineRepositoryTest {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Test
    public void testFindByOrderId() {
        // Arrange
        OrderLine orderLine1 = new OrderLine(1, 1, 2, BigDecimal.valueOf(50));
        OrderLine orderLine2 = new OrderLine(2, 1, 3, BigDecimal.valueOf(60));
        OrderLine orderLine3 = new OrderLine(3, 2, 1, BigDecimal.valueOf(70));

        orderLineRepository.save(orderLine1);
        orderLineRepository.save(orderLine2);
        orderLineRepository.save(orderLine3);

        // Act
        List<OrderLine> order1Lines = orderLineRepository.findByOrderId(1);
        List<OrderLine> order2Lines = orderLineRepository.findByOrderId(2);

        // Assert
        assertThat(order1Lines).hasSize(2);
        assertThat(order2Lines).hasSize(1);
    }
}
