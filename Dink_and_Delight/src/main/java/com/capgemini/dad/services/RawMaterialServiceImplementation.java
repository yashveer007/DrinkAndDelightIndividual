package com.capgemini.dad.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dad.dao.IRawMaterialOrderDao;
import com.capgemini.dad.entity.RawMaterialOrder;
import com.capgemini.dad.exceptions.RawMaterialNotFoundException;

@Service
@Transactional
public class RawMaterialServiceImplementation implements IRawMaterialService{

	
	@Autowired
	private IRawMaterialOrderDao rdao;
	
	@Override
	public RawMaterialOrder findRawMaterialOrderById(Long orderId) {
		
		Optional<RawMaterialOrder> optional=rdao.findById(orderId);
		if(optional.isPresent())
		{
			RawMaterialOrder rawMaterialOrder=optional.get();
			return rawMaterialOrder;
		}
		// TODO Auto-generated method stub
		throw  new RawMaterialNotFoundException("No such order exists");
	}

	@Override
	public RawMaterialOrder saveRawMaterialOrder(RawMaterialOrder rawMaterialOrder) {
		
		rawMaterialOrder=rdao.save(rawMaterialOrder);
		return rawMaterialOrder;
	
	}
	
}
