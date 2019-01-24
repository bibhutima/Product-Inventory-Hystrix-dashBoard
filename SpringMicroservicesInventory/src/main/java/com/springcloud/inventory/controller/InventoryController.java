package com.springcloud.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.inventory.entity.Inventory;
import com.springcloud.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/welcome")
	public String welcome() {
		System.out.println("Welcome");
		return "Hello Inventory";
	}
	
	
	@GetMapping("/all")
	public List getAllInventory() {
		return inventoryService.getAllInventory();
	}
	
	@GetMapping("/{code}")
	public Inventory getInventoryByProductCode(@PathVariable("code") String productCode) {
		return inventoryService.getInventoryByProductCode(productCode);
	}

}