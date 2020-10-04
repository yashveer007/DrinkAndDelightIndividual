package com.capgemini.dad.services;

import com.capgemini.dad.entity.ProductOrder;

public interface TrackProductOrderService {

	ProductOrder trackProductOrder(Long orderId);
}
