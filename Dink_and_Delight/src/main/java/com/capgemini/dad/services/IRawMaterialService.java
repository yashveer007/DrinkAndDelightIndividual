package com.capgemini.dad.services;

import com.capgemini.dad.entity.RawMaterialOrder;

public interface IRawMaterialService {

	RawMaterialOrder findRawMaterialOrderById(Long orderId);
	RawMaterialOrder saveRawMaterialOrder(RawMaterialOrder rawMaterialOrder);
	
}
