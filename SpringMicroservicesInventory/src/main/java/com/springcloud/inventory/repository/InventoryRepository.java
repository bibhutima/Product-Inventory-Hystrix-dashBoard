package com.springcloud.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Inventory findByProductCode(String productCode);
	
}
