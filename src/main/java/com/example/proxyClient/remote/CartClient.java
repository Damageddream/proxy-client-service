package com.example.proxyClient.remote;

import com.example.proxyClient.configuration.ClientConfiguration;
import com.example.proxyClient.dto.cartDTOs.CartDto;

import com.example.proxyClient.dto.cartDTOs.CartProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "Cart-Service-Client",
        url = "${feign.client.Cart-Service-Client.url}",
        configuration = ClientConfiguration.class
)
public interface CartClient {
    @GetMapping("/{uuid}")
    CartDto getCart(@PathVariable("uuid") String uuid);

    @PostMapping
    CartDto createCart();

    @PatchMapping("/{uuid}/add")
    CartDto addToCart(@PathVariable("uuid") String uuid, @RequestBody CartProductDto cartProduct);

    @PatchMapping("/{uuid}/remove")
    CartDto removeFromCart(@PathVariable("uuid") String uuid,@RequestBody CartProductDto cartProduct);

    @PutMapping("/{uuid}/clear")
    void clearCart(@PathVariable("uuid") String uuid);

    @DeleteMapping("/{uuid}/delete")
    void deleteCart(@PathVariable("uuid") String uuid);
}
