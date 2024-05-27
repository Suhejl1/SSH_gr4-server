package com.sshproject.bookstore.DTO;

import com.sshproject.bookstore.Entity.OrderLine;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderItemDTO {
    private int userId;
    private LocalDate orderDate;
    private String shippingAddress;
    private double orderTotal;
    private List<OrderLine> orderItems;
}
