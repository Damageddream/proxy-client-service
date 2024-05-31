package com.example.proxyClient.service;

import com.example.proxyClient.dto.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;
import com.example.proxyClient.remote.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProxyServiceImpl implements ProxyService {

    private final ProductClient productClient;

    @Override
    public List<ProductDto> findAllProducts(Optional<ProductTypes> productType) {
        List<ProductDto>products = productType.isPresent() ? productClient.getProducts(productType) :
                productClient.getProducts(Optional.empty());
        return products;
    }

    @Override
    public ProductDto addProduct(ProductDto product) {
        return productClient.addProduct(product);
    }
}
