package org.example.amazonclone.service;

import org.example.amazonclone.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Long userId);
    List<Order> getUserOrders(Long userId);
}
