package com.example.proxyClient.rest;

import com.example.proxyClient.dto.GetIdCommand;
import com.example.proxyClient.dto.productsDTOs.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;
import com.example.proxyClient.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts(Optional<ProductTypes> productType) {
        return productService.findAllProducts(productType);
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public ProductDto addConfig(@PathVariable Long id, @RequestBody GetIdCommand entityId) {
        return productService.addConfig(id, entityId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeConfig(@PathVariable Long id) {
        productService.deleteConfig(id);
    }

}
