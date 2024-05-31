package com.example.proxyClient.rest;

import com.example.proxyClient.dto.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;
import com.example.proxyClient.service.ProxyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProxyRestController {
    private final ProxyService proxyService;

    @GetMapping
    public List<ProductDto> getProducts(Optional<ProductTypes> productType) {
        return proxyService.findAllProducts(productType);
    }

    @PostMapping
    public ProductDto addProduct(ProductDto product) {
        return proxyService.addProduct(product);
    }

}
