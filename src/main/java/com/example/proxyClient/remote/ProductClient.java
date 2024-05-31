package com.example.proxyClient.remote;

import com.example.proxyClient.configuration.ClientConfiguration;
import com.example.proxyClient.dto.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Product-Service-Client",
        url = "${feign.client.Product-Service-Client.url}",
        configuration = ClientConfiguration.class
)
public interface ProductClient {
    @GetMapping
    List<ProductDto> getProducts(@RequestParam(required = false) Optional<ProductTypes> productType);
    @PostMapping
    ProductDto addProduct(ProductDto product);
}
