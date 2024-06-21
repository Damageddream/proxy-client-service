package com.example.proxyClient.dto.ordersDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String uuid;
    private String from;
    private String to;
    private List<InvoiceItemDto> products;
    private Double totalPrice;
    private String timeStamp;
}
