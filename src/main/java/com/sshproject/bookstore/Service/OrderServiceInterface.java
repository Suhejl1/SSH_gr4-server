package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Order;


import java.util.List;

public interface OrderServiceInterface {

    // get all orders of a specific user
    List<Order> getAllUserOrders(int userId);

    //place a new order from the user
     Order placeOrder(Order order);





    //other functions will be added if needed


}
