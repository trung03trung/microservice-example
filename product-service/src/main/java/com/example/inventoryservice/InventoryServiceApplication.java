package com.example.inventoryservice;

import com.example.inventoryservice.domain.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//        return args -> {
//            Inventory inventory = new Inventory();
//            inventory.setQuantity(100);
//            inventory.setSkuCode("iphone 14 pro max");
//
//            Inventory inventory1 = new Inventory();
//            inventory1.setQuantity(200);
//            inventory1.setSkuCode("iphone 14 pro max gold");
//            inventoryRepository.save(inventory);
//            inventoryRepository.save(inventory1);
//        };
//    }
}
