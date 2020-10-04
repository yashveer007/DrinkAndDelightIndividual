package com.capgemini.dad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dad.entity.ProductOrder;
import com.capgemini.dad.exceptions.ProductNotFoundException;
import com.capgemini.dad.services.TrackProductOrderService;

@RestController
@RequestMapping("/productOrder")
public class TrackProductOrderController {

	@Autowired
	private TrackProductOrderService service;

	//method for tracking the order details with the given orderID
	@GetMapping("/track/{orderId}")
	public ProductOrder trackProductOrder(@PathVariable Long orderId)  throws ProductNotFoundException {
		ProductOrder productOrder;
		productOrder= service.trackProductOrder(orderId); 
		if(productOrder!=null) {
			return productOrder;     																  // fetches the order details and returns
		}
		else
		{
			throw new ProductNotFoundException("orderId not present");          // if improperId is given
		}
	}
}




