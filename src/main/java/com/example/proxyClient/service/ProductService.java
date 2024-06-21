package com.example.proxyClient.service;

import com.example.proxyClient.dto.GetIdCommand;
import com.example.proxyClient.dto.productsDTOs.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> findAllProducts(Optional<ProductTypes> productType);

    ProductDto getProduct(Long id);

    ProductDto addConfig(Long id, GetIdCommand entityId);

    void deleteConfig(Long id);
}
