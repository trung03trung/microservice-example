package com.example.orderservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String orderId;
    List<OrderLineItemsDTO> orderLineItemsDTOS;
}
