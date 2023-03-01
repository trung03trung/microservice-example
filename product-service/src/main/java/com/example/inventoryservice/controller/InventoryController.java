package com.example.inventoryservice.controller;

import com.example.inventoryservice.service.InventoryService;
import com.example.inventoryservice.utils.ApiResponse;
import com.example.inventoryservice.utils.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    public ResponseEntity<ApiResponse<?>> isInStock(@PathVariable("sku-code") String skuCode){
        if(inventoryService.isInStock(skuCode))
            return ResponseEntity.ok(ApiResponse.success());
        else {
            return ResponseEntity.ok(ApiResponse.error(ErrorMessage.OUT_OF_STOCK));
        }
    }
}
