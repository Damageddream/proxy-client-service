package com.example.proxyClient.dto;

import com.example.proxyClient.dto.enums.ProductTypes;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;
@Getter
@RequiredArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public class ProductDto {
    private final Long id;
    private final String name;
    private final Double price;
    private final ProductTypes productType;
    private final boolean visibleToSell;
    private final Set<ProductDto> configurations;
    private final Set<ProductDto> possibleConfigurations;
}
