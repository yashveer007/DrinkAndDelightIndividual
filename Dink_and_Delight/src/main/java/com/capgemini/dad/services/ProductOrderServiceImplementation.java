package com.capgemini.dad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dad.dao.IProductOrderDao;
import com.capgemini.dad.entity.ProductOrder;
import com.capgemini.dad.exceptions.ProductNotFoundException;

@Service
@Transactional
public class ProductOrderServiceImplementation implements IProductOrderService{

	@Autowired
	private IProductOrderDao pdao;
	
	@Override
	public ProductOrder findProductOrderById(Long orderId) {
		
		Optional<ProductOrder> optional=pdao.findById(orderId);
		if(optional.isPresent())
		{
			ProductOrder productOrder=optional.get();
			return productOrder;
		}
		// TODO Auto-generated method stub
		throw  new ProductNotFoundException("No such order exists");
	}

	@Override
	public ProductOrder saveProductOrder(ProductOrder productOrder) {
		
		productOrder=pdao.save(productOrder);
		return productOrder;
	
	}

	
}
