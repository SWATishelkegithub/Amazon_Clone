package org.example.amazonclone.controller;

import org.example.amazonclone.model.Cart;
import org.example.amazonclone.model.CartItem;
import org.example.amazonclone.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Get all cart items as List<CartItem>
    @GetMapping("/items")
    public List<CartItem> getCartItems(@RequestParam Long userId) {
        return cartService.getUserCart(userId); // ✅ no type mismatch
    }

    // Get Cart object containing all items and total
    @GetMapping("/cart")
    public Cart getCart(@RequestParam Long userId) {
        List<CartItem> items = cartService.getUserCart(userId);

        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setItems(items);
        cart.setTotal(cartService.getCartTotal(userId)); // calculate total from service

        return cart; // ✅ ready-to-run
    }

    // Add item to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addToCart(item);
    }

    // Remove item from cart
    @DeleteMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }
}
