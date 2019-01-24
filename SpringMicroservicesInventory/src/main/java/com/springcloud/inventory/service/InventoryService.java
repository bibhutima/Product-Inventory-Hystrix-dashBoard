package com.springcloud.inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.inventory.dao.InventoryDao;
import com.springcloud.inventory.entity.Inventory;

@Service("inventoryService")
public class InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;

	@Transactional
	public List getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryDao.getAllInventory();
	}
	
	@Transactional
	public Inventory getInventoryByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return inventoryDao.getInventoryByProductCode(productCode);
	}

}
