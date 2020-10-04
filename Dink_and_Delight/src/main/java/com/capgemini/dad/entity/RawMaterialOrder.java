package com.capgemini.dad.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="RawMaterialOrder")
@Table(name="RawMaterialOrder")
public class RawMaterialOrder {

	@Id
	@Column(name="orderId")
	private Long rmorderId;
	
	@Column(name="name", nullable=false)
	private String rmName;
	
	@Column(name="supplierId")
	private Long supplierId;
	
	@Column(name="quantityValue",nullable=false)
	private double quantityValue;
	
	@Column(name="quantityUnit")
	private String quantityUnit;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Column(name="order_date")
	private LocalDate dateOfOrder;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Column(name="delDate")
	private LocalDate dateOfDelivery;
	
	@Column(name="price",nullable=false)
	private double totalPrice;
	
	@Column(name="price_per_unit",nullable=false)
	private double pricePerUnit = 0;
	
	@Enumerated(EnumType.STRING)
    @Column(name="status")
    private DeliveryStatus deliveryStatus;
	
	@Column(name="warehouseId", nullable=false)
	private Long warehouseID;

	public Long getRmorderId() {
		return rmorderId;
	}

	public void setRmorderId(Long rmorderId) {
		this.rmorderId = rmorderId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public double getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Long getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Long warehouseID) {
		this.warehouseID = warehouseID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfDelivery == null) ? 0 : dateOfDelivery.hashCode());
		result = prime * result + ((dateOfOrder == null) ? 0 : dateOfOrder.hashCode());
		result = prime * result + ((deliveryStatus == null) ? 0 : deliveryStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pricePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((quantityUnit == null) ? 0 : quantityUnit.hashCode());
		temp = Double.doubleToLongBits(quantityValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rmName == null) ? 0 : rmName.hashCode());
		result = prime * result + ((rmorderId == null) ? 0 : rmorderId.hashCode());
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((warehouseID == null) ? 0 : warehouseID.hashCode());
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
		RawMaterialOrder other = (RawMaterialOrder) obj;
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
		if (deliveryStatus != other.deliveryStatus)
			return false;
		if (Double.doubleToLongBits(pricePerUnit) != Double.doubleToLongBits(other.pricePerUnit))
			return false;
		if (quantityUnit == null) {
			if (other.quantityUnit != null)
				return false;
		} else if (!quantityUnit.equals(other.quantityUnit))
			return false;
		if (Double.doubleToLongBits(quantityValue) != Double.doubleToLongBits(other.quantityValue))
			return false;
		if (rmName == null) {
			if (other.rmName != null)
				return false;
		} else if (!rmName.equals(other.rmName))
			return false;
		if (rmorderId == null) {
			if (other.rmorderId != null)
				return false;
		} else if (!rmorderId.equals(other.rmorderId))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
			return false;
		if (warehouseID == null) {
			if (other.warehouseID != null)
				return false;
		} else if (!warehouseID.equals(other.warehouseID))
			return false;
		return true;
	}

	public RawMaterialOrder() {
		super();
	}

	public RawMaterialOrder(Long rmorderId, String rmName, Long supplierId, double quantityValue, String quantityUnit,
			LocalDate dateOfOrder, LocalDate dateOfDelivery, double totalPrice, double pricePerUnit,
			DeliveryStatus deliveryStatus, Long warehouseID) {
		super();
		this.rmorderId = rmorderId;
		this.rmName = rmName;
		this.supplierId = supplierId;
		this.quantityValue = quantityValue;
		this.quantityUnit = quantityUnit;
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
		this.totalPrice = totalPrice;
		this.pricePerUnit = pricePerUnit;
		this.deliveryStatus = deliveryStatus;
		this.warehouseID = warehouseID;
	}
	
	
	
}