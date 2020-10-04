package com.capgemini.dad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dad.entity.ProductStock;
import com.capgemini.dad.services.ProductStockService;

@RestController
@RequestMapping("/productStock")
public class ProductStockController {

	@Autowired
	private ProductStockService service;

	//method for updating the exit date in the productstock entity
	@PutMapping(value = "/updateExitDate", consumes = "application/json")
	public ResponseEntity<String> updateExitDate(@RequestBody() ProductStock productStock) {
		ResponseEntity<String> rs = new ResponseEntity<String>(service.updateExitDate(productStock), HttpStatus.OK);
		return rs;
	}

	//method for updating the stock details in the productstock entity
	@PutMapping(value = "/updateStock", consumes = "application/json")
	public ResponseEntity<String> updateStock(@RequestBody() ProductStock productStock) {
		ResponseEntity<String> rs = new ResponseEntity<String>(service.updateProductStock(productStock), HttpStatus.OK);
		return rs;
	}
}
