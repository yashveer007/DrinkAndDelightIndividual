package com.capgemini.dad.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RawMaterialStock {

	@Id
	private Long rmOrderId;
	
	private LocalDate manufacturingDate;
	
	private LocalDate expiryDate;
	
	private String qualityCheck;
	
	private LocalDate processDate;

	public Long getRmOrderId() {
		return rmOrderId;
	}

	public void setRmOrderId(Long rmOrderId) {
		this.rmOrderId = rmOrderId;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public LocalDate getProcessDate() {
		return processDate;
	}

	public void setProcessDate(LocalDate date) {
		this.processDate = date;
	}

	
	
	
}
