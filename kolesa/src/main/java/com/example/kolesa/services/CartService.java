package com.example.kolesa.services;

import com.example.kolesa.models.Cart;
import com.example.kolesa.models.Category;
import com.example.kolesa.models.Product;
import com.example.kolesa.repositories.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public List<Cart> getByPersonId(int id){
        return cartRepository.findByPersonId(id);
    }
    @Transactional
    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }
    @Transactional
    public void deleteCart(int id){
        cartRepository.deleteCartByProductId(id);
    }
}
