package com.example.proxyClient.service;

import com.example.proxyClient.dto.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;

import java.util.List;
import java.util.Optional;

public interface ProxyService {
    List<ProductDto> findAllProducts(Optional<ProductTypes> productType);
    ProductDto addProduct(ProductDto product);

    ProductDto getProduct(Long id);
}
