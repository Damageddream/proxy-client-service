package com.example.proxyClient.dto.cartDTOs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class CartDto {
    private String uuid;
    private List<CartItemDto> products;
    private double totalPrice;
}
