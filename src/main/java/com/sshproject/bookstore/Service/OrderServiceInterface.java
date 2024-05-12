package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Order;
import com.sshproject.bookstore.Entity.OrderLine;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface OrderServiceInterface {

    // get all orders of a specific user
    List<Order> getAllUserOrders(int userId);

    //place a new order from the user
    public void placeOrder(int userId, LocalDate orderDate, int paymentMethodId, int shippingAddressId,
                           BigDecimal orderTotal, int orderStatusId, List<OrderLine> orderLines);





    //other functions will be added if needed


}
