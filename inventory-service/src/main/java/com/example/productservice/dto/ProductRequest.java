package com.example.productservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@Valid
public class ProductRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private BigDecimal price;
}
