package com.capgemini.dad.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dad.dao.TrackProductOrderDao;
import com.capgemini.dad.entity.ProductOrder;

@Service
@Transactional
public class TrackProductOrderServiceImpl implements TrackProductOrderService {

	@Autowired
	private TrackProductOrderDao dao;

	@Override
	public ProductOrder trackProductOrder(Long orderId) {

	     return dao.findById(orderId).get();                                  // fetching the order details with the given orderId
	}
}
