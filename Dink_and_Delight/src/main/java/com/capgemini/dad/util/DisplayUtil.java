 package com.capgemini.dad.util;

import com.capgemini.dad.dto.DistributorDetails;
import com.capgemini.dad.dto.SupplierDetails;
import com.capgemini.dad.entity.Distributor;
import com.capgemini.dad.entity.Supplier;

public class DisplayUtil {
	
	public static SupplierDetails convertToSupplierDetails(Supplier request) {
		
		SupplierDetails supplier=new SupplierDetails();
		supplier.setSupplierId(request.getSupplierId());
		supplier.setSupplierName(request.getSupplierName());
		supplier.setPhoneNumber(request.getPhoneNumber());
		supplier.setAddress(request.getAddress());
		
		return supplier;
		
	}
	
	public static DistributorDetails convertToDistributorDetails(Distributor request) {
		
		DistributorDetails distributor=new DistributorDetails();
		
		distributor.setDistributorId(request.getDistributorId());
		distributor.setDistributorName(request.getDistributorName());
		distributor.setPhoneNumber(request.getPhoneNumber());
		distributor.setAddress(request.getAddress());
		
		return distributor;
	}
	
	public static Supplier convertToSupplier(SupplierDetails request) {
		
		Supplier supplier = new Supplier();
		
		supplier.setSupplierId(request.getSupplierId());
		supplier.setSupplierName(request.getSupplierName());
		supplier.setPhoneNumber(request.getPhoneNumber());
		supplier.setAddress(request.getAddress());
		
		return supplier;
	}
	
	public static Distributor convertToDistributor(DistributorDetails request) {
			
		Distributor distributor = new Distributor();
			
		distributor.setDistributorId(request.getDistributorId());
		distributor.setDistributorName(request.getDistributorName());
		distributor.setPhoneNumber(request.getPhoneNumber());
		distributor.setAddress(request.getAddress());
		
		return distributor;
	}

}
