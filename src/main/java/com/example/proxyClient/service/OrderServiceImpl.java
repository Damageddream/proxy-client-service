package com.example.proxyClient.service;

import com.example.proxyClient.dto.ordersDTOs.NewOrderDto;
import com.example.proxyClient.dto.ordersDTOs.OrderDto;
import com.example.proxyClient.remote.OrderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderClient orderClient;

    @Override
    public void createInvoice(String uuid) {
        orderClient.createInvoice(uuid);
    }

    @Override
    public OrderDto addOrder(NewOrderDto newOrderDto) {
        return orderClient.addOrder(newOrderDto);
    }

    @Override
    public OrderDto getOrder(String uuid) {
        return orderClient.getOrder(uuid);
    }

    @Override
    public OrderDto updateOrder(String uuid, NewOrderDto newOrderDto) {
        return orderClient.updateOrder(uuid, newOrderDto);
    }

    @Override
    public void deleteOrder(String uuid) {
        orderClient.deleteOrder(uuid);
    }
}
