package com.example.proxyClient.rest;

import com.example.proxyClient.dto.cartDTOs.CartDto;
import com.example.proxyClient.dto.cartDTOs.CartProductDto;
import com.example.proxyClient.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartRestController {

    private final CartService cartService;

    @GetMapping("/{uuid}")
    public CartDto getCart(@PathVariable String uuid) {
        return cartService.getCart(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto createCart() {
        return cartService.createCart();
    }

    @PatchMapping("/{uuid}/add")
    public CartDto addToCart(@PathVariable String uuid, @RequestBody CartProductDto cartProduct) {
        return cartService.addToCart(uuid, cartProduct);
    }

    @PatchMapping("/{uuid}/remove")
    public CartDto removeFromCart(@PathVariable String uuid, @RequestBody CartProductDto cartProduct) {
        return cartService.removeFromCart(uuid, cartProduct);
    }

    @PutMapping("/{uuid}/clear")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void clearCart(@PathVariable String uuid) {
        cartService.clearCart(uuid);
    }

    @DeleteMapping("/{uuid}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCart(@PathVariable String uuid) {
        cartService.deleteCart(uuid);
    }
}
