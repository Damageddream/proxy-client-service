package com.example.proxyClient.service;

import com.example.proxyClient.dto.cartDTOs.CartDto;
import com.example.proxyClient.dto.cartDTOs.CartProductDto;

public interface CartService {
    CartDto getCart(String uuid);
    CartDto createCart();
    CartDto addToCart(String uuid, CartProductDto cartProduct);
    CartDto removeFromCart(String uuid, CartProductDto cartProduct);
    void clearCart(String uuid);
    void deleteCart(String uuid);
}
