package com.capgemini.dad.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dad.dao.IDistributorDao;
import com.capgemini.dad.dao.IProductOrderDao;
import com.capgemini.dad.dao.IRawMaterialOrderDao;
import com.capgemini.dad.dao.ISupplierDao;
import com.capgemini.dad.entity.Distributor;
import com.capgemini.dad.entity.ProductOrder;
import com.capgemini.dad.entity.RawMaterialOrder;
import com.capgemini.dad.entity.Supplier;
import com.capgemini.dad.exceptions.DistributorNotFoundException;
import com.capgemini.dad.exceptions.InvalidArgumentException;
import com.capgemini.dad.exceptions.NotFoundException;
import com.capgemini.dad.exceptions.SupplierNotFoundException;


@Service
@Transactional
public class DisplayServiceImplementation implements IDisplayService {
	

	@Autowired
	private IDistributorDao distributorDao;
	
	@Autowired
	private ISupplierDao supplierDao;
	
	@Autowired
	private IRawMaterialOrderDao rawMaterialOrderDao;
	
	@Autowired
	private IProductOrderDao productOrderDao;
	
	/**
	 * @param supplierId This method will show account details by supplier_Id
	 * @return Supplier
	 */
	@Override
	public Supplier displaySupplierById(Long supplierId) {
		Supplier supplier=findSupplierById(supplierId);
		return supplier;
	}
	
	/**
	 * @param supplierId This method will fetch the Supplier by Supplier id
	 * @return Supplier
	 */
	@Override
	public Supplier findSupplierById(Long supplierId) {
		Optional<Supplier> optional = supplierDao.findById(supplierId);
		System.out.println("optional --->>"+optional.isPresent());
		if (optional.isPresent()) {
			Supplier supplier = optional.get();
			return supplier;
		}
		throw new SupplierNotFoundException("Supplier not found for supplier_id=" + supplierId);
	}
	
	/**
	 * @param distributorId This method will show account details by distributor_Id
	 * @return Distributor
	 */
	@Override
	public Distributor displayDistributorById(Long distributorId) {
		Distributor distributor=findDistributorById(distributorId);
		return distributor;
	}
	
	/**
	 * @param distributorId This method will fetch the Distributor by Distributor_Id
	 * @return Distributor
	 */
	@Override
	public Distributor findDistributorById(Long distributorId) {
		Optional<Distributor> optional = distributorDao.findById(distributorId);
		if (optional.isPresent()) {
			Distributor distributor = optional.get();
			return distributor;
		}
		throw new DistributorNotFoundException("Distributor not found for distributor_Id=" + distributorId);
	}
	
	
	/**
	 * @param  supplierId,deliveryStatus,startDate&startDateThis method will fetch the RawMaterialOrder 
	 * by supplierId,deliveryStatus,startDate & startDate
	 * @return RawMaterialOrder
	 */
	@Override
	public List<RawMaterialOrder> getAllRawMaterialOrder(Long supplierId, String deliveryStatus, LocalDate startDate,
			LocalDate endDate) { 
		List<RawMaterialOrder> listOfRawMaterialOrder =rawMaterialOrderDao.getRawMaterialOrder(supplierId, deliveryStatus, startDate, endDate);
		if(! listOfRawMaterialOrder.isEmpty()) {
		 return listOfRawMaterialOrder;
		 }
		throw new NotFoundException("List Of RawMaterialOrder not found for supplier_Id = " + supplierId+" deliveryStatus "+
		 deliveryStatus+" startdate "+startDate+" endDate "+endDate);
	}
	
	/**
	 * @param  distributorId,deliveryStatus,startDate&startDateThis method will fetch the List of Product Order 
	 * by supplierId,deliveryStatus,startDate & startDate
	 * @return List of Product Order
	 */
	@Override
	public List<ProductOrder> getAllProductOrder(Long distributorId, String deliveryStatus, LocalDate startDate,
			LocalDate endDate) {
		
		//System.out.println(" Service distributed id-->"+distributorId+"/n deliverystatus --->"+deliveryStatus+"/n startDate--->"+startDate+"/n end Date--->"+endDate);
        
		List<ProductOrder> listOfProductOrder =productOrderDao.getProductOrder(distributorId, deliveryStatus, startDate, endDate);
		if(!listOfProductOrder.isEmpty()) {
		 return listOfProductOrder;
		 }
		throw new NotFoundException("List Of ProductOrder not found for distributorId = " + distributorId+" deliveryStatus "+
		 deliveryStatus+" startdate "+startDate+" endDate "+endDate);
	}

	@Override
	public Supplier registerSupplier(Supplier supplier) {
		
		if(supplier==null) {
			throw new InvalidArgumentException("Please Enter Supplier Details");
		}
		supplier=supplierDao.save(supplier);
		return supplier;
	}

	@Override
	public Distributor registerDistributor(Distributor distributor) {

		if(distributor==null) {
			throw new InvalidArgumentException("Please Enter Distributor Details");
		}
		distributor=distributorDao.save(distributor);
		return distributor;
	}
	
	@PostConstruct
	public void initSupplier() {
        List<Supplier> users = Stream.of(
                new Supplier(new Long(new Integer(101)), "Yashveer Singh", "Amroha", "9870707187"),
                new Supplier(new Long(new Integer(102)), "naman", "delhi", "8945623464"),
                new Supplier(new Long(new Integer(103)), "vishal", "mathura", "54643314464"),
                new Supplier(new Long(new Integer(104)), "akash", "delhi", "4646464643434")
        ).collect(Collectors.toList());
        supplierDao.saveAll(users);
    }
	
	@PostConstruct
	public void initDistributor() {
        List<Distributor> users = Stream.of(
                new Distributor(new Long(new Integer(10001)), "little", "amroha", "9870707187"),
                new Distributor(new Long(new Integer(10002)), "bittu1", "delhi", "8945623464"),
                new Distributor(new Long(new Integer(10003)), "yogesh", "mathura", "54643314464"),
                new Distributor(new Long(new Integer(10004)), "puneet", "delhi", "4646464643434")
        ).collect(Collectors.toList());
        distributorDao.saveAll(users);
    }
	
	
}
