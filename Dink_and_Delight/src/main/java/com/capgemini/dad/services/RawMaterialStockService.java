package com.capgemini.dad.services;

import com.capgemini.dad.entity.RawMaterialStock;
import com.capgemini.dad.exceptions.RawMaterialException;
import com.capgemini.dad.model.RawMaterialStockModel;

// RAW MATERIAL STOCK SERVICE
public interface RawMaterialStockService {

	// ADD PROCESS DATE
	String updateProcessDate(RawMaterialStock rawMaterialStock) throws RawMaterialException;

	//UPDATE ManufactureDate, ExpiryDate, QualityCheck
	String updateRawMaterialStock(RawMaterialStock rawMaterialStock) throws RawMaterialException;
	
	//FIND STOCK USING ORDERiD
	RawMaterialStockModel findStockById(long orderId) throws RawMaterialException;
}
