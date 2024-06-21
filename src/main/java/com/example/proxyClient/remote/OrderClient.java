package com.example.proxyClient.remote;

import com.example.proxyClient.configuration.ClientConfiguration;
import com.example.proxyClient.dto.ordersDTOs.NewOrderDto;
import com.example.proxyClient.dto.ordersDTOs.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Order-Service-Client",
        url = "${feign.client.Order-Service-Client.url}",
        configuration = ClientConfiguration.class
)
public interface OrderClient {
    @PostMapping("/{uuid}")
    void createInvoice(@PathVariable("uuid") String uuid);

    @PostMapping
    OrderDto addOrder(@RequestBody NewOrderDto newOrderDto);

    @GetMapping("/{uuid}")
    OrderDto getOrder(@PathVariable("uuid") String uuid);

    @PutMapping("/{uuid}")
    OrderDto updateOrder(@PathVariable("uuid") String uuid, @RequestBody NewOrderDto newOrderDto);

    @DeleteMapping("/{uuid}")
    void deleteOrder(@PathVariable("uuid") String uuid);
}
