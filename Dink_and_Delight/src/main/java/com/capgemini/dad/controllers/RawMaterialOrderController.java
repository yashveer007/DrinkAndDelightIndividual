package com.capgemini.dad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.dad.model.RawMaterialOrderModel;
import com.capgemini.dad.services.RawMaterialServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/rawMaterialOrder")
public class RawMaterialOrderController {
	
	@Autowired
	RawMaterialServiceImpl service;
	
//	@GetMapping("/{id}")
//	public ResponseEntity<RawMaterialOrderModel> trackRawMaterialOrder(@PathVariable("id") Long id){
//		return new ResponseEntity<>(service.trackRawMaterialOrder(id), HttpStatus.OK);
//	}
	
	@GetMapping()
	public List<RawMaterialOrderModel> findAll(){
		return service.findAll();
	}
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<RawMaterialOrderModel> trackRawMaterialOrder(@PathVariable("id") Long id){
		ResponseEntity<RawMaterialOrderModel> result;
		RawMaterialOrderModel model = service.trackRawMaterialOrder(id);
		if(model==null) {
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			result = new ResponseEntity<>(model,HttpStatus.OK);
		}
		
		return result;
	}
	
	

}