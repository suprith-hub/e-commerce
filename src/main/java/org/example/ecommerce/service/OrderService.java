package org.example.ecommerce.service;

import org.example.ecommerce.exception.OrderException;
import org.example.ecommerce.model.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order) throws OrderException;

    public Order updateOrder(Order order) throws OrderException;

    public Order findOrderById(Long id) throws OrderException;

    public List<Order> findAllOrders() throws OrderException;

    public void deleteOrder(Long id) throws OrderException;

    public List<Order> userOrderHistory(Long customerId) throws OrderException;

    public List<Order> findAllOrdersByStatus(String status) throws OrderException;
}
