package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.DTO.OrderItemDTO;
import com.sshproject.bookstore.Entity.Inventory;
import com.sshproject.bookstore.Entity.Order;
import com.sshproject.bookstore.Entity.OrderLine;
import com.sshproject.bookstore.Entity.ShopCart;
import com.sshproject.bookstore.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceInterface{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ShopCartRepository shopCartRepository;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public List<Order> getAllUserOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }

    @Transactional
    @Override
    public Order placeOrder(OrderItemDTO order) {
        Order newOrder = new Order(order.getUserId(), order.getOrderDate(), order.getShippingAddress(), order.getOrderTotal());
        orderRepository.save(newOrder);

        List<OrderLine> products = order.getOrderItems();
        for(OrderLine orderLine : products) {
            orderLine.setOrderId(newOrder.getId());
            orderLineRepository.save(orderLine);
        }

        System.out.println("The user Id is:" + order.getUserId());

        //Update inventory
        List<OrderLine> items = order.getOrderItems();
        for(OrderLine product : items) {
            int productId = product.getProductItemId();
            int quantity =product.getQuantity();
            Optional<Inventory> inventory = inventoryRepository.findById(productId);
            inventory.get().setQuantity(inventory.get().getQuantity() - quantity);
        }


        //Clear the cart item


        ShopCart cartId =  shopCartRepository.findByUserId(order.getUserId());
        System.out.println("The cartId found:" + cartId.getId());
        //clear all cart items with this cart id
        cartRepository.deleteAllByCartId(cartId.getId());




        return newOrder;
    }

}
