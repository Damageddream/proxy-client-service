package com.example.proxyClient.service;

import com.example.proxyClient.dto.cartDTOs.CartDto;
import com.example.proxyClient.dto.cartDTOs.CartProductDto;
import com.example.proxyClient.remote.CartClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartClient cartClient;

    @Override
    public CartDto getCart(String uuid) {
        return cartClient.getCart(uuid);
    }

    @Override
    @Transactional
    public CartDto createCart() {
        return cartClient.createCart();
    }

    @Override
    @Transactional
    public CartDto addToCart(String uuid, CartProductDto cartProduct) {
        return cartClient.addToCart(uuid, cartProduct);
    }

    @Override
    public CartDto removeFromCart(String uuid, CartProductDto cartProduct) {
        return cartClient.removeFromCart(uuid, cartProduct);
    }

    @Override
    public void clearCart(String uuid) {
        cartClient.clearCart(uuid);
    }

    @Override
    public void deleteCart(String uuid) {
        cartClient.deleteCart(uuid);
    }
}
