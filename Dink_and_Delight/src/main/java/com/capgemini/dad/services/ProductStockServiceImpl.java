package com.capgemini.dad.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dad.dao.ProductStockDao;
import com.capgemini.dad.entity.ProductStock;

@Service
@Transactional
public class ProductStockServiceImpl implements ProductStockService {

	@Autowired
	private ProductStockDao dao;

	@Override
	public String updateExitDate(ProductStock productStock) {
		ProductStock productStock1;
		try {
			productStock1 = dao.findById(productStock.getOrderId()).get();                //check whether given orderId is present or not in the database
		} catch (Exception ex) {
			return "improper orderId";																				//if improperId is given
		}

		productStock1.setExitDate(productStock.getExitDate());
		dao.save(productStock1);                                                                                      // after succesfull check of orderId the exit date will be updated
		return "Exit Date Modified";

	}

	
	@Override
	public String updateProductStock(ProductStock productStock) {
		ProductStock productStock2;
		try {
			productStock2 = dao.findById(productStock.getOrderId()).get();            //check whether given orderId is present or not in the database
		} catch (Exception ex) {
			return "improper orderId";																			//if improperId is given
		}
		productStock2.setManufacturingDate(productStock.getManufacturingDate());
		productStock2.setExpiryDate(productStock.getExpiryDate());
		productStock2.setQualityCheck(productStock.getQualityCheck());
		dao.save(productStock2);                                                                                    // after succesfull check of orderId the productstock details will be updated
		return "Updated Stock Sucessfully";
	}
}
