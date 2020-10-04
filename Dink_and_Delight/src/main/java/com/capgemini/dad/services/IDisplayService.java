package com.capgemini.dad.services;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.dad.entity.Distributor;
import com.capgemini.dad.entity.ProductOrder;
import com.capgemini.dad.entity.RawMaterialOrder;
import com.capgemini.dad.entity.Supplier;

public interface IDisplayService {
	
	Supplier displaySupplierById(Long supplierId);
	
	Supplier findSupplierById(Long supplierId);
	
	Distributor displayDistributorById(Long distributorId);
	
	Distributor findDistributorById(Long distributorId);
	
	List<RawMaterialOrder> getAllRawMaterialOrder(Long supplierId,String deliveryStatus,LocalDate startDate ,LocalDate endDate);
	
	List<ProductOrder> getAllProductOrder(Long distributorId,String deliveryStatus,LocalDate startDate ,LocalDate endDate);
	
	Supplier registerSupplier(Supplier supplier);
	
	Distributor registerDistributor(Distributor distributor);

}
