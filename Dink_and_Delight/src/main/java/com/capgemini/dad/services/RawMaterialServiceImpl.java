package com.capgemini.dad.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dad.dao.RawMaterialDao;
import com.capgemini.dad.entity.RawMaterialOrder;
import com.capgemini.dad.model.RawMaterialOrderModel;

// RAW MATERIAL STOCK SERVICE IMPLEMENTATION
@Service
public class RawMaterialServiceImpl implements RawMaterialService {
	
	// RAW MATERIAL REPOSITORY AUTOWIRED
	@Autowired
	RawMaterialDao repo;
	
	
	//METHOD TO CONVERY MODEL TO ENTITY
	@SuppressWarnings("unused")
	private RawMaterialOrder of(RawMaterialOrderModel source) {
		RawMaterialOrder result = null;
		if(source!=null) {
			
			result = new RawMaterialOrder();
			result.setRmorderId(source.getRmorderId());
			result.setDateOfDelivery(source.getDateOfDelivery());
			result.setDateOfOrder(source.getDateOfDelivery());
			result.setDeliveryStatus(source.getDeliveryStatus());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setQuantityUnit(source.getQuantityUnit());
			result.setRmName(source.getRmName());
			result.setSupplierId(source.getSupplierId());
			result.setQuantityValue(source.getQuantityValue());
			result.setTotalPrice(source.getTotalPrice());
			result.setWarehouseID(source.getWarehouseID());
			
		}
		
		return result;	
	}
	
	//METHOD TO CONVERY ENTITY TO MODEL
	private RawMaterialOrderModel of(RawMaterialOrder source) {
		RawMaterialOrderModel result = null;
		if(source!=null) {
			
			result = new RawMaterialOrderModel();
			result.setRmorderId(source.getRmorderId());
			result.setDateOfDelivery(source.getDateOfDelivery());
			result.setDateOfOrder(source.getDateOfDelivery());
			result.setDeliveryStatus(source.getDeliveryStatus());
			result.setPricePerUnit(source.getPricePerUnit());
			result.setQuantityUnit(source.getQuantityUnit());
			result.setRmName(source.getRmName());
			result.setSupplierId(source.getSupplierId());
			result.setQuantityValue(source.getQuantityValue());
			result.setTotalPrice(source.getTotalPrice());
			result.setWarehouseID(source.getWarehouseID());
			
		}
		
		return result;	
	}
	
	
	// BOOLEAN METHOD TO CHECK IF ORDER EXISTS IN REPO USING ORDER ID
	@Override
	public boolean isOrderIdExists(Long orderId) {
		return repo.existsByRmorderId(orderId);
	}
	

	//METHOD TO TRACK/FIND DETAILS OF ORDER USING ORDERID
	@Override
	public RawMaterialOrderModel trackRawMaterialOrder(Long id) {
		
		return of(repo.findByRmorderId(id));
	}

	@Override
	public List<RawMaterialOrderModel> findAll() {
		return repo.findAll().stream().map(e->of(e)).collect(Collectors.toList());
	}
	
	

	

		
}
