package com.capgemini.dad.services;

import java.util.List;

import com.capgemini.dad.model.RawMaterialOrderModel;

public interface RawMaterialService {
	
	boolean isOrderIdExists(Long orderId);
	
	RawMaterialOrderModel trackRawMaterialOrder(Long id);

	List<RawMaterialOrderModel> findAll();

}
