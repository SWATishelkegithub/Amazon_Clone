package org.example.amazonclone.controller;

import org.example.amazonclone.model.Order;
import org.example.amazonclone.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Place order
    @PostMapping("/{userId}")
    public Order placeOrder(@PathVariable Long userId) {
        return orderService.placeOrder(userId);
    }

    // Order history
    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }
}
