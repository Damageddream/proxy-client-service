package com.example.proxyClient.remote;

import com.example.proxyClient.configuration.ClientConfiguration;
import com.example.proxyClient.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "Product-Service-Client",
        url = "${feign.client.Product-Service-Client.url}",
        configuration= ClientConfiguration.class
)
public interface ProductClient {
    @GetMapping
    List<ProductDto> getProducts();
}
