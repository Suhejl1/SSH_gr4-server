package com.sshproject.bookstore.Controllers;

import com.sshproject.bookstore.Entity.Order;

import com.sshproject.bookstore.Service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceInterface orderService;

    @GetMapping("api/v1/orders/{userId}")
    public ResponseEntity<List<Order>> getAllUrserOrders(@PathVariable int userId) {
        List<Order> orders = orderService.getAllUserOrders(userId);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(orders);
        }
    }

    @PostMapping("api/v1/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {
        // Save the Order to the database
        Order savedOrder = orderService.placeOrder(order);

        if (savedOrder != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
