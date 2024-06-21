package com.example.proxyClient.service;

import com.example.proxyClient.dto.GetIdCommand;
import com.example.proxyClient.dto.productsDTOs.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;
import com.example.proxyClient.remote.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductClient productClient;

    @Override
    public List<ProductDto> findAllProducts(Optional<ProductTypes> productType) {
        return productType.isPresent() ? productClient.getProducts(productType) : productClient.getProducts(Optional.empty());
    }

    @Override
    public ProductDto getProduct(Long id) {
        return productClient.getProduct(id);
    }

    @Override
    @Transactional
    public ProductDto addConfig(Long id, GetIdCommand entityId) {
        return productClient.addConfig(id, entityId);
    }

    @Override
    @Transactional
    public void deleteConfig(Long id) {
        productClient.deleteConfig(id);
    }
}
