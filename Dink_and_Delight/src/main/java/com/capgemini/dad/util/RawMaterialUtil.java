package com.capgemini.dad.util;

import com.capgemini.dad.dto.RawMaterialDetails;
import com.capgemini.dad.entity.RawMaterialOrder;

public class RawMaterialUtil {

	public static RawMaterialDetails convertToRawMaterialDetails(RawMaterialOrder request)
	{
		
		
		
		RawMaterialDetails rawMaterialDetails=new RawMaterialDetails();
		
		rawMaterialDetails.setRmorderId(request.getRmorderId());
		rawMaterialDetails.setRmName(request.getRmName());
		rawMaterialDetails.setSupplierId(request.getSupplierId());
		rawMaterialDetails.setQuantityValue(request.getQuantityValue());
		rawMaterialDetails.setPricePerUnit(request.getPricePerUnit());
		rawMaterialDetails.setDateOfOrder(request.getDateOfOrder());
		rawMaterialDetails.setDateOfDelivery(request.getDateOfDelivery());
		rawMaterialDetails.setPricePerUnit(request.getPricePerUnit());
		rawMaterialDetails.setTotalPrice(request.getTotalPrice());
		rawMaterialDetails.setWarehouseID(request.getWarehouseID());
		rawMaterialDetails.setDeliveryStatus(request.getDeliveryStatus());
		
	    return rawMaterialDetails;
		
		
	}
	
}
