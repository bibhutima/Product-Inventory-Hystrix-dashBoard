package com.springcloud.inventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcloud.inventory.entity.Inventory;
import com.springcloud.inventory.repository.InventoryRepository;

@Repository("inventoryDao")
public class InventoryDao {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	public List getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll();
	}

	public Inventory getInventoryByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return inventoryRepository.findByProductCode(productCode);
	}

}
