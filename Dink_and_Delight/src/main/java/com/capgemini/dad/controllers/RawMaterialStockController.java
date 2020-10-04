package com.capgemini.dad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dad.entity.RawMaterialStock;
import com.capgemini.dad.exceptions.RawMaterialException;
import com.capgemini.dad.model.RawMaterialStockModel;
import com.capgemini.dad.services.RawMaterialStockService;

// CONTROLLER FOR RAW MATERIAL STOCK
@RestController
@RequestMapping("/updateRawMaterial")
public class RawMaterialStockController {
	
	// AUTOWIRE STOCK SERVICE
	@Autowired
	RawMaterialStockService rmService;
	
	// GET RAW MATERIAL STOCK DETAILS

	@GetMapping("/{orderId}")
	public ResponseEntity<RawMaterialStockModel> findById(@PathVariable("orderId") Long orderId) throws RawMaterialException {
		ResponseEntity<RawMaterialStockModel> response = null;

		RawMaterialStockModel model= rmService.findStockById(orderId);

		if (model == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(model, HttpStatus.OK);
		}

		return response;
	}
	
	// ADD/UPDATE PROCESS DATE OF RAW MATERIAL STOCK
	@SuppressWarnings("unused")
	@PutMapping(value="/updateProcessDate", consumes="application/json")
	public ResponseEntity<String> updateProcessDate(@RequestBody()RawMaterialStock rawMaterialStock) throws RawMaterialException{
		ResponseEntity<String> e = new ResponseEntity<String>(rmService.updateProcessDate(rawMaterialStock), HttpStatus.OK);
		if(e!=null) {
			return e;
		}
		else {
			throw new RawMaterialException("No Raw Material found for given orderId");
		}
	}
	
	//UPDATE MANUFAXTURING-DATE, EXPIRY-DATE AND QUALITY CHECK
	@SuppressWarnings("unused")
	@PutMapping(value="/updateStock", consumes="application/json")
	public ResponseEntity<String> updateStock(@RequestBody()RawMaterialStock rawMaterialStock) throws RawMaterialException{
		ResponseEntity<String> e = new ResponseEntity<String>(rmService.updateRawMaterialStock(rawMaterialStock),HttpStatus.OK);
		if(e!=null) {
			return e;
		}
		else {
			throw new RawMaterialException("No Raw Material found for given order Id");
		}
	}
	
//	@PostMapping
//	public ResponseEntity<RawMaterialStockModel> addProcessDate(@RequestBody RawMaterialStockModel model) throws RawMaterialException{
//		
//		ResponseEntity<RawMaterialStockModel> response = null;
//		
//		model=rmService.addProcessDate(model);
//		
//		response= new ResponseEntity<>(model,HttpStatus.OK);
//		return response;	
//	}

}
