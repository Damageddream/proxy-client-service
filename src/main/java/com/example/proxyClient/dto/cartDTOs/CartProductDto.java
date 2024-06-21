package com.example.proxyClient.dto.cartDTOs;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder
@EqualsAndHashCode
public class CartProductDto {
    private final String name;
    private final Double price;
}
