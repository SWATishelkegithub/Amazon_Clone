package org.example.amazonclone.service;

import org.example.amazonclone.model.*;
import org.example.amazonclone.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    // Place an order for a user by converting cart items into order items
    @Override
    public Order placeOrder(Long userId) {

        // Get cart items for the user
        List<CartItem> cartItems = cartRepository.findByUserId(userId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty. Add items before placing order.");
        }

        // Create a new Order
        Order order = new Order();
        order.setUserId(userId);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());

        // Convert cart items to order items
        List<OrderItem> orderItems = cartItems.stream().map(cart -> {
            OrderItem item = new OrderItem();
            item.setProductId(cart.getProductId());
            item.setProductName("Product " + cart.getProductId()); // You can replace with actual product name
            item.setPrice(cart.getPrice());
            item.setQuantity(cart.getQuantity());
            item.setOrder(order); // Link to order
            return item;
        }).collect(Collectors.toList());

        // Calculate total amount
        double totalAmount = orderItems.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        order.setItems(orderItems);
        order.setTotalAmount(totalAmount);

        // Clear cart after placing order
        cartRepository.deleteAll(cartItems);

        // Save order and order items
        return orderRepository.save(order);
    }

    // Get all orders of a user
    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
