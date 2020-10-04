package com.capgemini.dad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dad.dao.RawMaterialStockDao;
import com.capgemini.dad.entity.RawMaterialStock;
import com.capgemini.dad.exceptions.RawMaterialException;
import com.capgemini.dad.model.RawMaterialStockModel;

//RAWMATERIAL STOCK SERVICE IMPLEMENTATION
@Service
public class RawMaterialStockServiceImpl implements RawMaterialStockService {

	// STOCK REPOSITORY AUTOWIRED
	@Autowired
	private RawMaterialStockDao rmDao;

	// METHOD TO UPDATE/ADD PROCESS DATE
	@Override
	public String updateProcessDate(RawMaterialStock rawMaterialStock) throws RawMaterialException {
		
		RawMaterialStock rawMaterialStock1 = rmDao.findByRmOrderId(rawMaterialStock.getRmOrderId());
		
		if(rawMaterialStock1==null) {
			throw new RawMaterialException("No Raw Material Found");
		}
		
		else {
			rawMaterialStock1.setProcessDate(rawMaterialStock.getProcessDate());
			rmDao.save(rawMaterialStock1);
			return "Process Date added successfully";
		}
	}
	
	
	// METHOD TO UPDATE MANUFACTURING-DATE , EXPIRY-DATE, QUALITY CHECK
	@Override
	public String updateRawMaterialStock(RawMaterialStock rawMaterialStock) throws RawMaterialException {
		
		RawMaterialStock rawMaterialStock2 = rmDao.findByRmOrderId(rawMaterialStock.getRmOrderId());
		
		if(rawMaterialStock2==null) {
			throw new RawMaterialException("No Raw Material Found");
		}
		
		else {
			rawMaterialStock2.setExpiryDate(rawMaterialStock.getExpiryDate());
			rawMaterialStock2.setManufacturingDate(rawMaterialStock.getManufacturingDate());
			rawMaterialStock2.setQualityCheck(rawMaterialStock.getQualityCheck());
			
			rmDao.save(rawMaterialStock2);
			return "Updated Stock Successfully";
		}
	}
	
	// FIND STOCK-DETAILS BY ORDERID
	@Override
	public RawMaterialStockModel findStockById(long orderId) throws RawMaterialException {
		Optional<RawMaterialStock> optional = rmDao.findById(orderId);
		if (optional.isPresent()) {
			return of(rmDao.findByRmOrderId(orderId));
		}
		else {
			throw new RawMaterialException("Order Id not found=" + orderId);
		}
		
	}
	

	// CONVERT RAWMATERIAL ENTITY TO MODEL
	private RawMaterialStockModel of(RawMaterialStock source) {
		RawMaterialStockModel result = null;
		if(source!=null) {
			result = new RawMaterialStockModel();
			result.setRmOrderId(source.getRmOrderId());
			result.setExpiryDate(source.getExpiryDate());
			result.setManufacturingDate(source.getManufacturingDate());
			result.setProcessDate(source.getProcessDate());
			result.setQualityCheck(source.getQualityCheck());
		}
			
		return result;
		
	}
	
	// CONVERT RAWMATERIAL MODEL TO ENTITY
	@SuppressWarnings("unused")
	private RawMaterialStock of(RawMaterialStockModel source) {
		RawMaterialStock result = null;
		if(source!=null) {
			result = new RawMaterialStock();
			result.setRmOrderId(source.getRmOrderId());
			result.setExpiryDate(source.getExpiryDate());
			result.setManufacturingDate(source.getManufacturingDate());
			result.setProcessDate(source.getProcessDate());
			result.setQualityCheck(source.getQualityCheck());
		}
			
		return result;
		
	}
//
//	@Override
//	public RawMaterialStockModel addProcessDate(RawMaterialStockModel model) throws RawMaterialException {
//		
//		if(model!=null) {
//			if(this.processDateCheck(model)) {
//				throw new RawMaterialException("NO raw material found with the given ID");
//			}
//			else{
//				if(model.getProcessDate().compareTo(LocalDate.now())<0) {
//					model=of(rmDao.save(of(model)));	
//				}
//				else {
//					model.setStatus("Invalid Process Date...");
//					return model;
//				}
//			}
//		}
//		model.setStatus("Process Date Updated...");
//		return model;
//	}
//	
//	@Override
//	public boolean processDateCheck(RawMaterialStockModel model) {
//		
//		if(rmDao.existsById(model.getRmOrderId())) {
//			return true;
//		}
//		return false;
//	}
//
	
	
	
}
