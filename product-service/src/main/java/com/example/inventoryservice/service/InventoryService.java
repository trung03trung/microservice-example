package com.example.inventoryservice.service;

import com.example.inventoryservice.domain.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode){
        log.info("InventoryService.isInStock(): {}",skuCode);
        Optional<Inventory> optional = inventoryRepository.findFirstBySkuCode(skuCode);
        return optional.isPresent();
    }
}
