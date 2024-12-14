package org.example.ecommerce.service.impl;

import org.example.ecommerce.exception.OrderException;
import org.example.ecommerce.model.Order;
import org.example.ecommerce.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Order order) throws OrderException {
        return null;
    }

    @Override
    public Order updateOrder(Order order) throws OrderException {
        return null;
    }

    @Override
    public Order findOrderById(Long id) throws OrderException {
        return null;
    }

    @Override
    public List<Order> findAllOrders() throws OrderException {
        return List.of();
    }

    @Override
    public void deleteOrder(Long id) throws OrderException {

    }

    @Override
    public List<Order> userOrderHistory(Long customerId) throws OrderException {
        return List.of();
    }

    @Override
    public List<Order> findAllOrdersByStatus(String status) throws OrderException {
        return List.of();
    }
}
