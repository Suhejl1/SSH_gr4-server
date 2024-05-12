package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Order;
import com.sshproject.bookstore.Entity.OrderLine;
import com.sshproject.bookstore.Repository.OrderLineRepository;
import com.sshproject.bookstore.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderService implements OrderServiceInterface{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderLineRepository orderLineRepository;


    @Override
    public List<Order> getAllUserOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void placeOrder(int userId, LocalDate orderDate, int paymentMethodId, int shippingAddressId, BigDecimal orderTotal, int orderStatusId, List<OrderLine> orderLines) {
        // Create a new Order instance
        Order order = new Order(userId, orderDate, paymentMethodId, shippingAddressId, orderTotal);

        // Save the Order to the database
        Order savedOrder = orderRepository.save(order);

        // If needed, save the associated OrderLine entities
        // You can iterate over orderLines and set the order ID to the saved order's ID before saving them

        for (OrderLine orderLine : orderLines) {
            orderLine.setOrderId(savedOrder.getId());
            // Save the OrderLine to the database
             orderLineRepository.save(orderLine);
        }
    }

}
