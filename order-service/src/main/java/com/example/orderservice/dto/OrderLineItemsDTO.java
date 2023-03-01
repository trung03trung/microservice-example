package com.example.orderservice.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class OrderLineItemsDTO {
    private String orderId;
    private BigDecimal price;
    private Integer quantity;
    private String skuCode;
}
