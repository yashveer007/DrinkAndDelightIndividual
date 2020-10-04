package com.capgemini.dad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dad.dto.RawMaterialDetails;
import com.capgemini.dad.entity.RawMaterialOrder;
import com.capgemini.dad.services.IRawMaterialService;
import com.capgemini.dad.util.RawMaterialUtil;


@RequestMapping("/rawMaterial")
@RestController
public class TrackRawMaterialOrderController {

	@Autowired
	private IRawMaterialService rawMaterialService;
	
	
	@PostMapping("/add")
	public ResponseEntity<RawMaterialDetails> add(@RequestBody RawMaterialDetails rawMaterialDetails)
	{
		RawMaterialOrder rawMaterialOrder=new RawMaterialOrder();
		
		rawMaterialOrder.setRmorderId(rawMaterialDetails.getRmorderId());
		rawMaterialOrder.setRmName(rawMaterialDetails.getRmName());
		rawMaterialOrder.setSupplierId(rawMaterialDetails.getSupplierId());
		System.out.println("raw material Quantity -->>"+rawMaterialDetails.getQuantityUnit());
		rawMaterialOrder.setQuantityValue(rawMaterialDetails.getQuantityValue());
		rawMaterialOrder.setQuantityUnit(rawMaterialDetails.getQuantityUnit());
		rawMaterialOrder.setDateOfOrder(rawMaterialDetails.getDateOfOrder());
		rawMaterialOrder.setDateOfDelivery(rawMaterialDetails.getDateOfDelivery());
		rawMaterialOrder.setTotalPrice(rawMaterialDetails.getTotalPrice());
		rawMaterialOrder.setPricePerUnit(rawMaterialDetails.getPricePerUnit());
	    rawMaterialOrder.setDeliveryStatus(rawMaterialDetails.getDeliveryStatus());
		rawMaterialOrder.setWarehouseID(rawMaterialDetails.getWarehouseID());
		rawMaterialOrder.setPricePerUnit(rawMaterialDetails.getPricePerUnit());
		
		
		rawMaterialOrder=rawMaterialService.saveRawMaterialOrder(rawMaterialOrder);
		RawMaterialDetails pod=RawMaterialUtil.convertToRawMaterialDetails(rawMaterialOrder);
		ResponseEntity<RawMaterialDetails> responseEntity=new  ResponseEntity<>(pod, HttpStatus.OK);
		return responseEntity;
		
		
	}

	
	
}
