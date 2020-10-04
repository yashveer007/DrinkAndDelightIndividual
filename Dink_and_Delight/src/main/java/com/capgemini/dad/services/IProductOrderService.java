package com.capgemini.dad.services;

import com.capgemini.dad.entity.ProductOrder;

public interface IProductOrderService {
	
	ProductOrder findProductOrderById(Long orderId);
	
	ProductOrder saveProductOrder(ProductOrder productOrder);

}
