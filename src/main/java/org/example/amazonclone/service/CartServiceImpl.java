package org.example.amazonclone.service;

import org.example.amazonclone.model.CartItem;
import org.example.amazonclone.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartItem addToCart(CartItem item) {

        Optional<CartItem> existing =
                cartRepository.findByUserIdAndProductId(
                        item.getUserId(),
                        item.getProductId()
                );

        if (existing.isPresent()) {
            CartItem cartItem = existing.get();
            cartItem.setQuantity(
                    cartItem.getQuantity() + item.getQuantity()
            );
            return cartRepository.save(cartItem);
        }

        return cartRepository.save(item);
    }

    @Override
    public List<CartItem> getUserCart(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public double getCartTotal(Long userId){
        List<CartItem> items = cartRepository.findByUserId(userId);
        double total=0;
        for (CartItem item : items) {
            total+=item.getQuantity() * item.getUserId();
        }
        return total;
    }
}

