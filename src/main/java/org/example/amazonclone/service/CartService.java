package org.example.amazonclone.service;

import org.example.amazonclone.model.CartItem;

import java.util.List;

public interface CartService {
    CartItem addToCart(CartItem item);

    List<CartItem> getUserCart(Long userId);

    void removeFromCart(Long id);
    double getCartTotal(Long userId);

}
