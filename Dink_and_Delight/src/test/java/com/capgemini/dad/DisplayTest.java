package com.capgemini.dad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.dad.entity.DeliveryStatus;
import com.capgemini.dad.entity.Distributor;
import com.capgemini.dad.entity.ProductOrder;
import com.capgemini.dad.entity.RawMaterialOrder;
import com.capgemini.dad.entity.Supplier;
import com.capgemini.dad.services.IDisplayService;
import com.capgemini.dad.services.IProductOrderService;
import com.capgemini.dad.services.IRawMaterialService;

@SpringBootTest
public class DisplayTest {
	

	@Autowired
	private IDisplayService displayService;

	@Autowired
	private IRawMaterialService rawMaterialService;
	
	@Autowired
	private IProductOrderService productOrderService;

	/*
	 * Test for fetch the Supplier from given supplierId
	 */
	@Test
	public void testShowSupplierById() {

		Supplier supplier = new Supplier();
		supplier.setSupplierName("Yash");
		supplier.setSupplierId(new Long(new Integer(101)));
		supplier.setPhoneNumber("8267026107");
		supplier.setAddress("Amroha, U.P");
		Supplier expected = displayService.registerSupplier(supplier);
		Supplier actual = displayService.findSupplierById(supplier.getSupplierId());
		Assertions.assertEquals(expected, actual);

	}

	/*
	 * Test for fetch the Distributor from given distributorId
	 */
	@Test
	public void testShowDistributorById() {

		Distributor distributor = new Distributor();
		distributor.setDistributorId(new Long(10101));
		distributor.setDistributorName("Ajay Pal Singh");
		distributor.setPhoneNumber("9876562321");
		distributor.setAddress("New delhi");

		Distributor expected = displayService.registerDistributor(distributor);
		Distributor actual = displayService.findDistributorById(distributor.getDistributorId());

		Assertions.assertEquals(expected, actual);

	}
	
	/*
	 * Test for fetch the List Of Raw Material Order from given supplierId,deliveryStatus,startDate,endDate
	 */
	@Test
	public void testListOfRawMaterialOrder() {
		
		RawMaterialOrder order1 = new RawMaterialOrder();
		order1.setRmorderId(new Long(10001));
		order1.setSupplierId(new Long(102));
		order1.setPricePerUnit(20.00);
		order1.setQuantityUnit("20");
		order1.setDeliveryStatus(DeliveryStatus.DELIVERED);
		order1.setQuantityValue(56);
		order1.setRmName("Rice");
		order1.setTotalPrice(112.00);
		order1.setWarehouseID(new Long(40031));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date= "2020-03-25";
		LocalDate localDate1=LocalDate.parse(date, formatter);
		order1.setDateOfOrder(LocalDate.parse(date, formatter));
	    date = "2020-03-30";
	    LocalDate localDate2=LocalDate.parse(date, formatter);
		order1.setDateOfDelivery(LocalDate.parse(date, formatter));
		rawMaterialService.saveRawMaterialOrder(order1);
		
		RawMaterialOrder order2 = new RawMaterialOrder();
		order2.setRmorderId(new Long(10020));
		order2.setSupplierId(new Long(101));
		order2.setPricePerUnit(20.00);
		order2.setQuantityUnit("20");
		order2.setDeliveryStatus(DeliveryStatus.DELIVERED);
		order2.setQuantityValue(56);
		order2.setRmName("Rice");
		order2.setTotalPrice(112.00);
		order2.setWarehouseID(new Long(40031));
		date = "2020-04-20";
		order2.setDateOfOrder(LocalDate.parse(date, formatter));
	    date = "2020-05-01";
	    order2.setDateOfDelivery(LocalDate.parse(date, formatter));
		rawMaterialService.saveRawMaterialOrder(order2);
		
		List<RawMaterialOrder> actual=displayService.getAllRawMaterialOrder(new Long(new Integer(102)),"DELIVERED",localDate1 ,localDate2);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<RawMaterialOrder> expected=new ArrayList();
		expected.add(order1);
		boolean result =expected.equals(actual);
		Assertions.assertEquals(true, result);
		
	}
	
	/*
	 * Test for fetch the List Of Product Order from given distributorId,deliveryStatus,startDate,endDate
	 */
	@Test
	public void testListOfProductOrder() {
		ProductOrder order1= new ProductOrder();
		order1.setOrderId(new Long(500));
		order1.setName("Floor");
		order1.setDistributorId(new Long(10001));
		order1.setPricePerUnit(50.00);
		order1.setQuantityUnit("High");
		order1.setQuantityValue(20.00);
		order1.setTotalPrice(1000.00);
		order1.setWarehouseId(new Long(40012));
		order1.setDeliveryStatus("CANCELLED");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date= "2020-03-25";
		LocalDate localDate1=LocalDate.parse(date, formatter);
		order1.setDateOfOrder(localDate1);
	    date = "2020-03-30";
	    LocalDate localDate2=LocalDate.parse(date, formatter);
	    order1.setDateOfDelivery(localDate2);
	    productOrderService.saveProductOrder(order1);
	    
	    ProductOrder order2= new ProductOrder();
	    order2.setOrderId(new Long(600));
	    order2.setName("Floor");
	    order2.setDistributorId(new Long(10014));
	    order2.setPricePerUnit(50.00);
	    order2.setQuantityUnit("High");
	    order2.setQuantityValue(30.00);
	    order2.setTotalPrice(1500.00);
	    order2.setWarehouseId(new Long(40012));
	    order2.setDeliveryStatus("CANCELLED");
		date= "2020-01-03";
		order2.setDateOfOrder(LocalDate.parse(date, formatter));
	    date = "2020-01-18";
	    order2.setDateOfDelivery(LocalDate.parse(date, formatter));
	    productOrderService.saveProductOrder(order2);
	    
	    List<ProductOrder> actual=displayService.getAllProductOrder(new Long(new Integer(10001)),"CANCELLED", localDate1, localDate2);
	    @SuppressWarnings({ "rawtypes", "unchecked" })
		List<ProductOrder> expected=new ArrayList();
		expected.add(order1);
		boolean result =expected.equals(actual);
		
		Assertions.assertEquals(true, result);
		
	}

}
