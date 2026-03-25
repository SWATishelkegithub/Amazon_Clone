package org.example.amazonclone.model;

import java.util.List;

public class Cart {

    private Long userId;             // ID of the user who owns this cart
    private List<CartItem> items;    // List of items in the cart
    private double total;            // Total price of all items

    // Default constructor
    public Cart() {
    }

    // Parameterized constructor
    public Cart(Long userId, List<CartItem> items, double total) {
        this.userId = userId;
        this.items = items;
        this.total = total;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Optional: for debugging
    @Override
    public String toString() {
        return "Cart{" +
                "userId=" + userId +
                ", items=" + items +
                ", total=" + total +
                '}';
    }

    public Long getProductId() {
        return null;
    }
}
