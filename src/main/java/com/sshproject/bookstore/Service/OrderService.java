package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Order;
import com.sshproject.bookstore.Entity.OrderLine;
import com.sshproject.bookstore.Repository.OrderLineRepository;
import com.sshproject.bookstore.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Order placeOrder(Order order) {
        // Step 1: Save the Order to the database
        Order savedOrder = orderRepository.save(order);

        // Step 2: Fetch OrderLines associated with the Order's orderId
        List<OrderLine> orderLines = orderLineRepository.findByOrderId(savedOrder.getId());

        // Step 3: Optionally, set orderId for each OrderLine
        for (OrderLine orderLine : orderLines) {
            orderLine.setOrderId(savedOrder.getId());
        }

        // Step 4: Save each OrderLine to the database
        orderLineRepository.saveAll(orderLines);
        return savedOrder;
    }

}
