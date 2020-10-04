package com.capgemini.dad;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.dad.entity.ProductOrder;
import com.capgemini.dad.entity.ProductStock;
import com.capgemini.dad.services.ProductStockService;


@SpringBootTest
class DrinkAndDelightApplicationTests {
	@Autowired
	private ProductStockService serviceStock;
	
	@Test
	public void trackingOrderSuccessfully() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String Url = "http://localhost:8001/productOrder/track/100001";
		URI uri = new URI(Url);
		ResponseEntity<ProductOrder> result = restTemplate.getForEntity(uri, ProductOrder.class);
		ProductOrder order = result.getBody();
		Assertions.assertEquals(200, result.getStatusCodeValue());
		Assertions.assertNotNull(order);
	}

	@Test
	public void updateExitDateSuccessfully() {

		ProductStock productStock = new ProductStock();
		productStock.setOrderId((long) 100001);
		productStock.setExitDate(new Date(18 - 04 - 2020));
		
		String result=serviceStock.updateExitDate(productStock);
		Assertions.assertEquals("Exit Date Modified",result);
		}

	@Test
	public void updateProductStockSuccessfully() {
		
		ProductStock productStock = new ProductStock();
		productStock.setOrderId((long) 100001);
		productStock.setExpiryDate(new Date(10 - 10 - 2021));
		productStock.setManufacturingDate(new Date(10 - 10 - 2020));
		productStock.setQualityCheck("completed");
		
		String result=serviceStock.updateProductStock(productStock);
		Assertions.assertEquals("Updated Stock Sucessfully",result);
	}

}
