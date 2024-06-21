package com.example.proxyClient.service;

import com.example.proxyClient.dto.ordersDTOs.NewOrderDto;
import com.example.proxyClient.dto.ordersDTOs.OrderDto;

public interface OrderService {
    void createInvoice(String uuid);
    OrderDto addOrder(NewOrderDto newOrderDto);
    OrderDto getOrder(String uuid);
    OrderDto updateOrder(String uuid, NewOrderDto newOrderDto);
    void deleteOrder(String uuid);
}
