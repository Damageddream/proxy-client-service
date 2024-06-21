package com.example.proxyClient.rest;

import com.example.proxyClient.dto.ordersDTOs.NewOrderDto;
import com.example.proxyClient.dto.ordersDTOs.OrderDto;
import com.example.proxyClient.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderRestController {
    private final OrderService orderService;

    @PostMapping("/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createInvoice(@PathVariable("uuid") String uuid) {
        orderService.createInvoice(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto addOrder(@RequestBody NewOrderDto newOrderDto) {
        return orderService.addOrder(newOrderDto);
    }

    @GetMapping("/{uuid}")
    public OrderDto getOrder(@PathVariable("uuid") String uuid) {
        return orderService.getOrder(uuid);
    }

    @PutMapping("/{uuid}")
    public OrderDto updateOrder(@PathVariable("uuid") String uuid, @RequestBody NewOrderDto newOrderDto) {
        return orderService.updateOrder(uuid, newOrderDto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("uuid") String uuid) {
        orderService.deleteOrder(uuid);
    }
}
