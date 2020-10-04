package com.capgemini.dad.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ProductOrder")
@Table(name="ProductOrder")	
public class ProductOrder {
	
	@Id
	@Column(length=6)
	private Long orderId;
	@Column(length=15)
	private String name;
	@Column(length=6, name="distributorId")
	private Long distributorId;
	@Column(length=8)
	private Double quantityValue;
	@Column(length=20)
	private LocalDate dateOfOrder;
	@Column(length=20 ,name="delDate")
	private LocalDate dateOfDelivery;
	@Column(length=8)
	private Double pricePerUnit;
	@Column(length=8)
	private Double totalPrice;
	@Column(length=6)
	private Long warehouseId;
	
	@Column(length=15,name="status")
	private String deliveryStatus;
	
	@Column(length=8)
	private String quantityUnit;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	public Double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(Double quantityValue) {
		this.quantityValue = quantityValue;
	}
	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public LocalDate getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(LocalDate dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public Double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfDelivery == null) ? 0 : dateOfDelivery.hashCode());
		result = prime * result + ((dateOfOrder == null) ? 0 : dateOfOrder.hashCode());
		result = prime * result + ((deliveryStatus == null) ? 0 : deliveryStatus.hashCode());
		result = prime * result + ((distributorId == null) ? 0 : distributorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((pricePerUnit == null) ? 0 : pricePerUnit.hashCode());
		result = prime * result + ((quantityUnit == null) ? 0 : quantityUnit.hashCode());
		result = prime * result + ((quantityValue == null) ? 0 : quantityValue.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((warehouseId == null) ? 0 : warehouseId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOrder other = (ProductOrder) obj;
		if (dateOfDelivery == null) {
			if (other.dateOfDelivery != null)
				return false;
		} else if (!dateOfDelivery.equals(other.dateOfDelivery))
			return false;
		if (dateOfOrder == null) {
			if (other.dateOfOrder != null)
				return false;
		} else if (!dateOfOrder.equals(other.dateOfOrder))
			return false;
		if (deliveryStatus == null) {
			if (other.deliveryStatus != null)
				return false;
		} else if (!deliveryStatus.equals(other.deliveryStatus))
			return false;
		if (distributorId == null) {
			if (other.distributorId != null)
				return false;
		} else if (!distributorId.equals(other.distributorId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (pricePerUnit == null) {
			if (other.pricePerUnit != null)
				return false;
		} else if (!pricePerUnit.equals(other.pricePerUnit))
			return false;
		if (quantityUnit == null) {
			if (other.quantityUnit != null)
				return false;
		} else if (!quantityUnit.equals(other.quantityUnit))
			return false;
		if (quantityValue == null) {
			if (other.quantityValue != null)
				return false;
		} else if (!quantityValue.equals(other.quantityValue))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (warehouseId == null) {
			if (other.warehouseId != null)
				return false;
		} else if (!warehouseId.equals(other.warehouseId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductOrder [orderId=" + orderId + ", name=" + name + ", distributorId=" + distributorId
				+ ", quantityValue=" + quantityValue + ", dateOfOrder=" + dateOfOrder + ", dateOfDelivery="
				+ dateOfDelivery + ", pricePerUnit=" + pricePerUnit + ", totalPrice=" + totalPrice + ", warehouseId="
				+ warehouseId + ", deliveryStatus=" + deliveryStatus + ", quantityUnit=" + quantityUnit + "]";
	}
	public ProductOrder(Long orderId, String name, Long distributorId, Double quantityValue, LocalDate dateOfOrder,
			LocalDate dateOfDelivery, Double pricePerUnit, Double totalPrice, Long warehouseId, String deliveryStatus,
			String quantityUnit) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.distributorId = distributorId;
		this.quantityValue = quantityValue;
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
		this.pricePerUnit = pricePerUnit;
		this.totalPrice = totalPrice;
		this.warehouseId = warehouseId;
		this.deliveryStatus = deliveryStatus;
		this.quantityUnit = quantityUnit;
	}
	public ProductOrder() {
		super();
	}
	
	
}