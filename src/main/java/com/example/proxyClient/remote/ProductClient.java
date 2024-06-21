package com.example.proxyClient.remote;

import com.example.proxyClient.configuration.ClientConfiguration;
import com.example.proxyClient.dto.GetIdCommand;
import com.example.proxyClient.dto.productsDTOs.ProductDto;
import com.example.proxyClient.dto.enums.ProductTypes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Product-Service-Client",
        url = "${feign.client.Product-Service-Client.url}",
        configuration = ClientConfiguration.class
)
public interface ProductClient {
    @GetMapping
    List<ProductDto> getProducts(@RequestParam(required = false) Optional<ProductTypes> productType);

    @GetMapping("/{id}")
    ProductDto getProduct(@PathVariable("id") Long id);

    @PutMapping("/{id}/config")
    ProductDto addConfig(@PathVariable("id") Long id, @RequestBody GetIdCommand entityId);

    @DeleteMapping("/{id}/config")
    void deleteConfig(@PathVariable("id") Long id);
}
