package com.example.inventoryservice.repository;

import com.example.inventoryservice.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,String> {
    Optional<Inventory> findFirstBySkuCode(String skuCode);
}
