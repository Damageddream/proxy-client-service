package com.example.proxyClient.dto.ordersDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemDto {
    private String name;
    private Integer quantity;
    private Double unit_cost;
}
