package com.capgemini.dad.util;

import com.capgemini.dad.dto.ProductOrderDetails;
import com.capgemini.dad.entity.ProductOrder;

public class ProductOrderUtil {
public static ProductOrderDetails convertToProductDetails(ProductOrder request)
{
	ProductOrderDetails productOrderDetails=new ProductOrderDetails();
	productOrderDetails.setOrderId(request.getOrderId());
	productOrderDetails.setName(request.getName());
	productOrderDetails.setDistributorId(request.getDistributorId());
	productOrderDetails.setQuantityValue(request.getQuantityValue());
	productOrderDetails.setDateOfOrder(request.getDateOfOrder());
	productOrderDetails.setDateOfDelivery(request.getDateOfDelivery());
	productOrderDetails.setPricePerUnit(request.getPricePerUnit());
	productOrderDetails.setTotalPrice(request.getTotalPrice());
	productOrderDetails.setWarehouseId(request.getWarehouseId());
	productOrderDetails.setDeliveryStatus(request.getDeliveryStatus());
    productOrderDetails.setQuantityUnit(request.getQuantityUnit());	
	
    return productOrderDetails;
}
}
